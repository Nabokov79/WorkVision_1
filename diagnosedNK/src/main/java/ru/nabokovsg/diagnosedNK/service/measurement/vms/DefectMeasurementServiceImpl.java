package ru.nabokovsg.diagnosedNK.service.measurement.vms;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.diagnosedNK.exceptions.NotFoundException;
import ru.nabokovsg.diagnosedNK.mapper.measurement.vms.DefectMeasurementMapper;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.DefectMeasurement;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.QDefectMeasurement;
import ru.nabokovsg.diagnosedNK.model.norms.Defect;
import ru.nabokovsg.diagnosedNK.repository.measurement.vms.DefectMeasurementRepository;
import ru.nabokovsg.diagnosedNK.service.norms.DefectService;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.DefectMeasurementDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.ResponseDefectMeasurementDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefectMeasurementServiceImpl implements DefectMeasurementService {

    private final DefectMeasurementRepository repository;
    private final DefectMeasurementMapper mapper;
    private final ParameterMeasurementService parameterMeasurementService;
    private final EntityManager em;
    private final DefectService defectsService;
    private final CalculationParameterMeasurementService calculationParameterService;

    @Override
    public ResponseDefectMeasurementDto save(DefectMeasurementDto defectMeasurementDto) {
        DefectMeasurement defectMeasurement = getByPredicate(defectMeasurementDto);
        Defect defect = defectsService.getById(defectMeasurementDto.getDefectId());
        if (defectMeasurement == null) {
            defectMeasurement = repository.save(mapper.mapToDefectMeasurement(defectMeasurementDto, defect));
        }
        defectMeasurement.getParameterMeasurements().addAll(parameterMeasurementService.save(defect.getActionsOnParameter()
                                                                    , defectMeasurement
                                                                    , defectMeasurementDto.getParameterMeasurements()));
        return mapper.mapToResponseDefectMeasurementDto(defectMeasurement);
    }

    @Override
    public List<ResponseDefectMeasurementDto> getAll(Long id) {
        return repository.findAllByVisualMeasuringSurveyEquipmentDiagnosedTaskJournalId(id)
                         .stream()
                         .map(mapper::mapToResponseDefectMeasurementDto)
                         .toList();
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("Defect measurement with id=%s not found for delete", id));
    }

    private DefectMeasurement getByPredicate(DefectMeasurementDto defectMeasurementDto) {
        QDefectMeasurement defect = QDefectMeasurement.defectMeasurement;
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(defect.surveyJournalId.eq(defectMeasurementDto.getSurveyJournalId()));
        booleanBuilder.and(defect.equipmentId.eq(defectMeasurementDto.getEquipmentId()));
        booleanBuilder.and(defect.elementId.eq(defectMeasurementDto.getElementId()));
        if (defectMeasurementDto.getPartElementId() != null && defectMeasurementDto.getPartElementId() > 0) {
            booleanBuilder.and(defect.partElementId.eq(defectMeasurementDto.getPartElementId()));
        }
        booleanBuilder.and(defect.defectId.eq(defectMeasurementDto.getDefectId()));
        if (defectMeasurementDto.getPartElementId() != null) {
            booleanBuilder.and(defect.partElementId.eq(defectMeasurementDto.getPartElementId()));
        }
        return new JPAQueryFactory(em).from(defect)
                .select(defect)
                .where(booleanBuilder)
                .fetchOne();
    }
}