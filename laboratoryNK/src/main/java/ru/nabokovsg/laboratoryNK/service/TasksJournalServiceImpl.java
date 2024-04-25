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
import ru.nabokovsg.laboratoryNK.exceptions.NotFoundException;
import ru.nabokovsg.laboratoryNK.mapper.TasksJournalMapper;
import ru.nabokovsg.laboratoryNK.model.QTasksJournal;
import ru.nabokovsg.laboratoryNK.model.TasksJournal;
import ru.nabokovsg.laboratoryNK.model.equipmentDiagnosed.EquipmentDiagnosed;
import ru.nabokovsg.laboratoryNK.model.laboratoryEmployee.LaboratoryEmployee;
import ru.nabokovsg.laboratoryNK.repository.TasksJournalRepository;
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

    @Override
    public ResponseTasksJournalDto save(TasksJournalDto taskJournalDto) {
        return null;
    }

    @Override
    public ResponseTasksJournalDto update(TasksJournalDto taskJournalDto) {
        return null;
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

    private TasksJournal getTasksJournalData(TasksJournalDto taskJournalDto) {
        BranchDto branch = client.getBranch(taskJournalDto.getBranchId());
        EquipmentDiagnosed equipment = equipmentDiagnosedService.getById(taskJournalDto.getEquipmentId());
        Map<Long, LaboratoryEmployee> employees = employeeService.getAllById(
                                                          Stream.of(taskJournalDto.getLaboratoryEmployeesIds()
                                                                  , List.of(taskJournalDto.getLaboratoryEmployeeId()))
                                                          .flatMap(Collection::stream)
                                                          .toList())
                                                          .stream()
                                                          .collect(Collectors.toMap(LaboratoryEmployee::getId, l -> l));
        HeatSupplyAreaDto heatSupplyArea = branch.getHeatSupplyAreas().stream().collect(Collectors.toMap(HeatSupplyAreaDto::getId, h -> h)).get(taskJournalDto.getHeatSupplyAreaId());
        ExploitationRegionDto exploitationRegion = heatSupplyArea.getExploitationRegions().stream().collect(Collectors.toMap(ExploitationRegionDto::getId, e -> e)).get(taskJournalDto.getExploitationRegionId());
        String building = builderService.buildBuilding(exploitationRegion.getBuildings().stream().collect(Collectors.toMap(b -> b.getAddress().getId(), b -> b)).get(taskJournalDto.getAddressId()));
        TasksJournal taskJournal = mapper.mapToTaskJournal();
        return taskJournal;
    }
}