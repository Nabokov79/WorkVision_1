package ru.nabokovsg.laboratoryNK.service.equipmentDiagnosed;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.dto.equipmentDiagnosed.equipmentType.ResponseEquipmentTypeDto;
import ru.nabokovsg.laboratoryNK.dto.equipmentDiagnosed.equipments.EquipmentDto;
import ru.nabokovsg.laboratoryNK.model.equipmentDiagnosed.EquipmentType;
import ru.nabokovsg.laboratoryNK.mapper.equipmentDiagnosed.EquipmentTypeMapper;
import ru.nabokovsg.laboratoryNK.model.equipmentDiagnosed.QEquipmentType;
import ru.nabokovsg.laboratoryNK.repository.equipmentDiagnosed.EquipmentTypeRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EquipmentTypeServiceImpl implements EquipmentTypeService {

    private final EquipmentTypeRepository repository;
    private final EquipmentTypeMapper mapper;
    private final EntityManager em;

    @Override
    public EquipmentType create(EquipmentDto equipmentDto) {
        return Objects.requireNonNullElseGet(getByPredicate(equipmentDto)
                        , () -> repository.save(mapper.mapToEquipmentType(equipmentDto))
        );
    }

    @Override
    public List<ResponseEquipmentTypeDto> getAll() {
        return repository.findAll()
                         .stream()
                         .map(mapper::mapFullEquipmentTypeDto)
                         .toList();
    }

    private EquipmentType getByPredicate(EquipmentDto equipmentDto) {
        QEquipmentType equipmentType = QEquipmentType.equipmentType;
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (equipmentDto.getEquipmentName() != null) {
            booleanBuilder.and(QEquipmentType.equipmentType.equipmentName.eq(equipmentDto.getEquipmentName()));
        }
        if (equipmentDto.getModel() != null) {
            booleanBuilder.and(QEquipmentType.equipmentType.model.eq(equipmentDto.getModel()));
        }
        return new JPAQueryFactory(em).from(equipmentType)
                .select(equipmentType)
                .where(booleanBuilder)
                .fetchOne();
    }
}