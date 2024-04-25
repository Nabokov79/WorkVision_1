package ru.nabokovsg.laboratoryNK.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.client.LaboratoryClient;
import ru.nabokovsg.laboratoryNK.dto.client.BranchDto;
import ru.nabokovsg.laboratoryNK.dto.client.BuildingDto;
import ru.nabokovsg.laboratoryNK.dto.client.ExploitationRegionDto;
import ru.nabokovsg.laboratoryNK.dto.client.HeatSupplyAreaDto;
import ru.nabokovsg.laboratoryNK.dto.tasksJournal.ResponseTasksJournalDto;
import ru.nabokovsg.laboratoryNK.dto.tasksJournal.TasksJournalDto;
import ru.nabokovsg.laboratoryNK.exceptions.BadRequestException;
import ru.nabokovsg.laboratoryNK.exceptions.NotFoundException;
import ru.nabokovsg.laboratoryNK.mapper.TasksJournalMapper;
import ru.nabokovsg.laboratoryNK.model.QTasksJournal;
import ru.nabokovsg.laboratoryNK.model.TasksJournal;
import ru.nabokovsg.laboratoryNK.model.equipmentDiagnosed.EquipmentDiagnosed;
import ru.nabokovsg.laboratoryNK.model.laboratoryEmployee.LaboratoryEmployee;
import ru.nabokovsg.laboratoryNK.repository.TasksJournalRepository;
import ru.nabokovsg.laboratoryNK.service.diagnosticDocument.DiagnosticDocumentService;
import ru.nabokovsg.laboratoryNK.service.equipmentDiagnosed.EquipmentDiagnosedService;
import ru.nabokovsg.laboratoryNK.service.laboratoryEmployee.LaboratoryEmployeeService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class TasksJournalServiceImpl implements TasksJournalService {

    private final TasksJournalRepository repository;
    private final TasksJournalMapper mapper;
    private final EntityManager em;
    private final LaboratoryClient client;
    private final EquipmentDiagnosedService equipmentDiagnosedService;
    private final LaboratoryEmployeeService employeeService;
    private final StringBuilderService builderService;
    private final DiagnosticDocumentService documentService;

    @Override
    public ResponseTasksJournalDto save(TasksJournalDto taskJournalDto) {
        if (repository.existsByDateAndEquipmentId(taskJournalDto.getDate(), taskJournalDto.getEquipmentId())) {
            throw new BadRequestException(
                    String.format("TasksJournal by date=%s and equipmentId=%s is found", taskJournalDto.getDate()
                                                                                      , taskJournalDto.getEquipmentId())
            );
        }
        EquipmentDiagnosed equipment = equipmentDiagnosedService.getById(taskJournalDto.getEquipmentId());
        ResponseTasksJournalDto taskJournal = mapper.mapToResponseTaskJournalDto(
                                                         repository.save(getTasksJournalData(taskJournalDto, equipment))
        );
        documentService.save(taskJournal);
        return taskJournal;
    }

    @Override
    public ResponseTasksJournalDto update(TasksJournalDto taskJournalDto) {
        if (repository.existsById(taskJournalDto.getId())) {
            documentService.existsByTaskJournalId(taskJournalDto.getId());
            EquipmentDiagnosed equipment = equipmentDiagnosedService.getById(taskJournalDto.getEquipmentId());
            ResponseTasksJournalDto taskJournal = mapper.mapToResponseTaskJournalDto(
                    repository.save(getTasksJournalData(taskJournalDto, equipment))
            );
            documentService.update(taskJournal);
            return taskJournal;
        }
        throw new NotFoundException(
                String.format("TasksJournal with id=%s not found for update", taskJournalDto.getId())
        );
    }

    @Override
    public List<ResponseTasksJournalDto> getAll(LocalDate startPeriod, LocalDate endPeriod) {
        QTasksJournal tasksJournal = QTasksJournal.tasksJournal;
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (startPeriod != null && endPeriod != null) {
            booleanBuilder.and(tasksJournal.date.after(startPeriod));
            booleanBuilder.and(QTasksJournal.tasksJournal.date.before(endPeriod));
        } else {
            booleanBuilder.and(tasksJournal.date.eq(LocalDate.now()));
        }
        return new JPAQueryFactory(em).from(tasksJournal)
                .select(tasksJournal)
                .where(booleanBuilder)
                .fetch()
                .stream()
                .map(mapper::mapToResponseTaskJournalDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("TasksJournal with id=%s not found for delete", id));
    }

    private TasksJournal getTasksJournalData(TasksJournalDto taskJournalDto, EquipmentDiagnosed equipment) {
        BranchDto branch = client.getBranch(taskJournalDto.getBranchId());
        HeatSupplyAreaDto heatSupplyArea = branch.getHeatSupplyAreas()
                                                 .stream()
                                                 .collect(Collectors.toMap(HeatSupplyAreaDto::getId, h -> h))
                                                 .get(taskJournalDto.getHeatSupplyAreaId());
        ExploitationRegionDto exploitationRegion = heatSupplyArea.getExploitationRegions()
                                                        .stream()
                                                        .collect(Collectors.toMap(ExploitationRegionDto::getId, e -> e))
                                                        .get(taskJournalDto.getExploitationRegionId());
        return setLaboratoryEmployee(mapper.mapToTaskJournal(taskJournalDto
                                                       , branch.getFullName()
                                                       , heatSupplyArea.getFullName()
                                                       , exploitationRegion.getFullName()
                                                       , builderService.buildBuilding(
                                                         exploitationRegion.getBuildings()
                                                        .stream()
                                                        .collect(Collectors.toMap(b -> b.getAddress().getId(), b -> b))
                                                        .get(taskJournalDto.getAddressId()))
                                                       , builderService.buildEquipmentDiagnosed(equipment))
                                    , taskJournalDto);
    }

    private TasksJournal setLaboratoryEmployee(TasksJournal taskJournal, TasksJournalDto taskJournalDto) {
        Map<Long, LaboratoryEmployee> employees = employeeService.getAllById(
                                                    Stream.of(taskJournalDto.getLaboratoryEmployeesIds()
                                                                    , List.of(taskJournalDto.getLaboratoryEmployeeId()))
                                                            .flatMap(Collection::stream)
                                                            .toList())
                                            .stream()
                                            .collect(Collectors.toMap(LaboratoryEmployee::getId, l -> l));
        taskJournal.setChief(employees.get(taskJournalDto.getLaboratoryEmployeeId()));
        taskJournal.setEmployees(taskJournalDto.getLaboratoryEmployeesIds()
                                               .stream()
                                               .map(employees::get)
                                               .collect(Collectors.toSet()));
        return taskJournal;
    }
}