package ru.nabokovsg.diagnosedNK.mapper.common;

import org.mapstruct.Mapper;
import ru.nabokovsg.diagnosedNK.dto.common.equipmentRepair.EquipmentRepairDto;
import ru.nabokovsg.diagnosedNK.dto.common.equipmentRepair.ResponseEquipmentRepairDto;
import ru.nabokovsg.diagnosedNK.model.common.EquipmentRepair;

@Mapper(componentModel = "spring")
public interface EquipmentRepairMapper {

    EquipmentRepair mapToEquipmentRepair(EquipmentRepairDto repairDto);
    ResponseEquipmentRepairDto mapToResponseEquipmentRepairDto(EquipmentRepair equipmentRepair);
}