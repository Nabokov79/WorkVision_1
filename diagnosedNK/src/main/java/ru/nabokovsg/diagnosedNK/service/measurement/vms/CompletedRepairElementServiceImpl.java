package ru.nabokovsg.diagnosedNK.service.measurement.vms;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.completedRepairElement.CompletedRepairElementDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.completedRepairElement.ResponseCompletedRepairElementDto;
import ru.nabokovsg.diagnosedNK.exceptions.NotFoundException;
import ru.nabokovsg.diagnosedNK.mapper.measurement.vms.CompletedRepairElementMapper;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.EquipmentElement;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.PartElement;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.CompletedRepairElement;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.QCompletedRepairElement;
import ru.nabokovsg.diagnosedNK.model.norms.ElementRepair;
import ru.nabokovsg.diagnosedNK.repository.measurement.vms.CompletedRepairElementRepository;
import ru.nabokovsg.diagnosedNK.service.equipmentDiagnosed.EquipmentElementService;
import ru.nabokovsg.diagnosedNK.service.norms.ElementRepairService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompletedRepairElementServiceImpl implements CompletedRepairElementService {

    private final CompletedRepairElementRepository repository;
    private final CompletedRepairElementMapper mapper;
    private final ElementRepairService repairService;
    private final ParameterMeasurementService parameterMeasurementService;
    private final EntityManager em;
    private final EquipmentElementService equipmentElementService;

    @Override
    public ResponseCompletedRepairElementDto save(CompletedRepairElementDto repairDto) {
        CompletedRepairElement repair = getByPredicate(repairDto);
        ElementRepair elementRepair = repairService.getById(repairDto.getRepairId());
        if (repair == null) {
            EquipmentElement element = equipmentElementService.getById(repairDto.getElementId());
            Map<Long, PartElement> partsElement = element.getPartsElement()
                    .stream().collect(Collectors.toMap(PartElement::getId, p -> p));
            repair = mapper.mapWithEquipmentElement(repairDto, elementRepair, element);
            if(repairDto.getPartElementId() != null) {
                repair = mapper.mapWithPartElement(repair, partsElement.get(repairDto.getPartElementId()));
            }
            repair = repository.save(repair);
        }
        repair.setParameterMeasurements(parameterMeasurementService.save(elementRepair.getTypeCalculation()
                                                                       , elementRepair.getMeasuredParameters()
                                                                       , repair.getParameterMeasurements()
                                                                       , repairDto.getParameterMeasurements()));
        return mapper.mapToResponseCompletedRepairElementDto(repair);
    }

    @Override
    public List<ResponseCompletedRepairElementDto> getAll(Long id) {
        return repository.findAllBySurveyJournalId(id)
                         .stream()
                         .map(mapper::mapToResponseCompletedRepairElementDto)
                         .toList();
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("Completed repair element with id=%s not found for delete", id));
    }

    private CompletedRepairElement getByPredicate(CompletedRepairElementDto repairDto) {
        QCompletedRepairElement repair = QCompletedRepairElement.completedRepairElement;
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(repair.surveyJournalId.eq(repairDto.getSurveyJournalId()));
        booleanBuilder.and(repair.equipmentId.eq(repairDto.getEquipmentId()));
        booleanBuilder.and(repair.elementId.eq(repairDto.getElementId()));
        booleanBuilder.and(repair.repairId.eq(repairDto.getRepairId()));
        if (repairDto.getPartElementId() != null) {
            booleanBuilder.and(repair.partElementId.eq(repairDto.getPartElementId()));
        }
        return new JPAQueryFactory(em).from(repair)
                .select(repair)
                .where(booleanBuilder)
                .fetchOne();
    }
}