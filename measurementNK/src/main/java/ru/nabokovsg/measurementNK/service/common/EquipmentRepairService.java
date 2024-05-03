package ru.nabokovsg.measurementNK.service.common;

import ru.nabokovsg.measurementNK.dto.common.equipmentRepair.EquipmentRepairDto;
import ru.nabokovsg.measurementNK.dto.common.equipmentRepair.ResponseEquipmentRepairDto;

import java.util.List;

public interface EquipmentRepairService {

    ResponseEquipmentRepairDto save(EquipmentRepairDto repairDto);

    ResponseEquipmentRepairDto update(EquipmentRepairDto repairDto);

    List<ResponseEquipmentRepairDto> getAll(Long id);

    void delete(Long id);
}