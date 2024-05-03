package ru.nabokovsg.measurementNK.service.norms;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.nabokovsg.measurementNK.dto.norms.acceptableThickness.AcceptableThicknessDto;
import ru.nabokovsg.measurementNK.dto.norms.acceptableThickness.ResponseAcceptableThicknessDto;
import ru.nabokovsg.measurementNK.mapper.norms.AcceptableThicknessMapper;
import ru.nabokovsg.measurementNK.model.norms.AcceptableThickness;
import ru.nabokovsg.measurementNK.model.norms.QAcceptableThickness;
import ru.nabokovsg.measurementNK.repository.norms.AcceptableThicknessRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AcceptableThicknessServiceImpl implements AcceptableThicknessService {

    private final AcceptableThicknessRepository repository;
    private final AcceptableThicknessMapper mapper;
    private final EntityManager em;

    @Override
    public ResponseAcceptableThicknessDto save(AcceptableThicknessDto thicknessDto) {
        return mapper.mapToResponseAcceptableThicknessDto(
                Objects.requireNonNullElseGet(getByPredicate(thicknessDto)
                        , () -> repository.save(mapper.mapToAcceptableThickness(thicknessDto))));
    }

    @Override
    public ResponseAcceptableThicknessDto update(AcceptableThicknessDto thicknessDto) {
        if (repository.existsById(thicknessDto.getId())) {
            return mapper.mapToResponseAcceptableThicknessDto(
                    repository.save(mapper.mapToAcceptableThickness(thicknessDto))
            );
        }
        throw new NotFoundException(
                String.format("AcceptableThickness with id=%s not found for update", thicknessDto.getId())
        );
    }

    @Override
    public List<ResponseAcceptableThicknessDto> getAll(Long id) {
        return repository.findAllByEquipmentTypeId(id)
                .stream()
                .map(mapper::mapToResponseAcceptableThicknessDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("AcceptableThickness with id=%s not found for delete", id));
    }

    private AcceptableThickness getByPredicate(AcceptableThicknessDto thicknessDto) {
        QAcceptableThickness thickness = QAcceptableThickness.acceptableThickness;
        return new JPAQueryFactory(em).from(thickness)
                .select(thickness)
                .where(gePredicate(thicknessDto,thickness))
                .fetchOne();
    }

    private BooleanBuilder gePredicate(AcceptableThicknessDto thicknessDto, QAcceptableThickness thickness) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (thicknessDto.getEquipmentTypeId() != null) {
            booleanBuilder.and(thickness.equipmentTypeId.eq(thicknessDto.getEquipmentTypeId()));
        }
        if (thicknessDto.getElementId() != null) {
            booleanBuilder.and(thickness.elementId.eq(thicknessDto.getElementId()));
        }
        if (thicknessDto.getPartElementId() != null) {
            booleanBuilder.and(thickness.partElementId.eq(thicknessDto.getPartElementId()));
        }
        if (thicknessDto.getDiameter() != null) {
            booleanBuilder.and(thickness.diameter.eq(thicknessDto.getDiameter()));
        }
        return booleanBuilder;
    }
}