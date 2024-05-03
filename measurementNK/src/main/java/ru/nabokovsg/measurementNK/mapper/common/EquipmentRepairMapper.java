package ru.nabokovsg.measurementNK.mapper.common;

import org.mapstruct.Mapper;
import ru.nabokovsg.measurementNK.dto.common.equipmentRepair.EquipmentRepairDto;
import ru.nabokovsg.measurementNK.dto.common.equipmentRepair.ResponseEquipmentRepairDto;
import ru.nabokovsg.measurementNK.model.common.EquipmentRepair;

@Mapper(componentModel = "spring")
public interface EquipmentRepairMapper {

    EquipmentRepair mapToEquipmentRepair(EquipmentRepairDto repairDto);
    ResponseEquipmentRepairDto mapToResponseEquipmentRepairDto(EquipmentRepair equipmentRepair);
}