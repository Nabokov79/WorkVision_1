package ru.nabokovsg.diagnosedNK.service.common;

import ru.nabokovsg.diagnosedNK.dto.common.equipmentRepair.EquipmentRepairDto;
import ru.nabokovsg.diagnosedNK.dto.common.equipmentRepair.ResponseEquipmentRepairDto;

import java.util.List;

public interface EquipmentRepairService {

    ResponseEquipmentRepairDto save(EquipmentRepairDto repairDto);

    ResponseEquipmentRepairDto update(EquipmentRepairDto repairDto);

    List<ResponseEquipmentRepairDto> getAll(Long id);

    void delete(Long id);
}