package ru.nabokovsg.laboratoryNK.mapper.equipmentDiagnosed;

import org.mapstruct.Mapper;
import ru.nabokovsg.laboratoryNK.dto.equipmentDiagnosed.equipmentType.ResponseEquipmentTypeDto;
import ru.nabokovsg.laboratoryNK.dto.equipmentDiagnosed.equipments.EquipmentDto;
import ru.nabokovsg.laboratoryNK.model.equipmentDiagnosed.EquipmentType;

@Mapper(componentModel = "spring")
public interface EquipmentTypeMapper {

    EquipmentType mapToEquipmentType(EquipmentDto equipmentDto);

    ResponseEquipmentTypeDto mapFullEquipmentTypeDto(EquipmentType equipmentType);
}