package ru.nabokovsg.diagnosedNK.service.measurement.vms;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.visualInspection.ResponseVisualInspectionDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.visualInspection.VisualInspectionDto;
import ru.nabokovsg.diagnosedNK.exceptions.NotFoundException;
import ru.nabokovsg.diagnosedNK.mapper.measurement.vms.VisualInspectionMapper;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.QVisualInspection;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.VisualInspection;
import ru.nabokovsg.diagnosedNK.repository.measurement.vms.VisualInspectionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisualInspectionServiceImpl implements VisualInspectionService {

    private final VisualInspectionRepository repository;
    private final VisualInspectionMapper mapper;
    private final EntityManager em;

    @Override
    public ResponseVisualInspectionDto save(VisualInspectionDto inspectionDto) {
        VisualInspection inspection = getByPredicate(inspectionDto);
        if (inspection == null) {
            inspection = repository.save(mapper.mapToVisualInspection(inspectionDto));
        }
        return mapper.mapToResponseVisualInspectionDto(inspection);
    }

    @Override
    public ResponseVisualInspectionDto update(VisualInspectionDto inspectionDto) {
        if (repository.existsById(inspectionDto.getId())) {
            return mapper.mapToResponseVisualInspectionDto(
                    repository.save(mapper.mapToVisualInspection(inspectionDto)));
        }
        throw new NotFoundException(
                String.format("VisualInspection with id=%s not found for update", inspectionDto.getId()));
    }

    @Override
    public List<ResponseVisualInspectionDto> getAll(Long id) {
        return repository.findAllBySurveyJournalId(id)
                         .stream()
                         .map(mapper::mapToResponseVisualInspectionDto)
                         .toList();
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("VisualInspection with id=%s not found for delete", id));
    }

    private VisualInspection getByPredicate(VisualInspectionDto inspectionDto) {
        QVisualInspection inspection = QVisualInspection.visualInspection;
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(inspection.surveyJournalId.eq(inspectionDto.getSurveyJournalId()));
        booleanBuilder.and(inspection.equipmentId.eq(inspectionDto.getEquipmentId()));
        booleanBuilder.and(inspection.elementId.eq(inspectionDto.getElementId()));
        booleanBuilder.and(inspection.inspection.eq(inspectionDto.getInspection()));
        return new JPAQueryFactory(em).from(inspection)
                                      .select(inspection)
                                      .where(booleanBuilder)
                                      .fetchOne();
    }
}