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
import ru.nabokovsg.diagnosedNK.model.measurement.vms.CompletedRepairElement;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.QCompletedRepairElement;
import ru.nabokovsg.diagnosedNK.model.norms.ElementRepair;
import ru.nabokovsg.diagnosedNK.repository.measurement.vms.CompletedRepairElementRepository;
import ru.nabokovsg.diagnosedNK.service.norms.ElementRepairService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompletedRepairElementServiceImpl implements CompletedRepairElementService {

    private final CompletedRepairElementRepository repository;
    private final CompletedRepairElementMapper mapper;
    private final ElementRepairService repairService;
    private final ParameterMeasurementService parameterMeasurementService;
    private final EntityManager em;

    @Override
    public ResponseCompletedRepairElementDto save(CompletedRepairElementDto repairDto) {
        CompletedRepairElement repair = getByPredicate(repairDto);
        ElementRepair elementRepair = repairService.getById(repairDto.getRepairId());
        if (repair == null) {
            repair = repository.save(mapper.mapToCompletedRepairElement(repairDto, elementRepair));
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