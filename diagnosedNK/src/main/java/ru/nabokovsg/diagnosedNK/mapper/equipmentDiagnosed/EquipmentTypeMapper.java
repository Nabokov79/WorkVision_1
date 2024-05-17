package ru.nabokovsg.diagnosedNK.mapper.equipmentDiagnosed;

import org.mapstruct.Mapper;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.equipmentType.EquipmentTypeDto;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.equipmentType.ResponseEquipmentTypeDto;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.EquipmentType;

@Mapper(componentModel = "spring")
public interface EquipmentTypeMapper {

    EquipmentType mapToEquipmentType(EquipmentTypeDto equipmentTypeDto);

    ResponseEquipmentTypeDto mapResponseEquipmentTypeDto(EquipmentType equipmentType);
}