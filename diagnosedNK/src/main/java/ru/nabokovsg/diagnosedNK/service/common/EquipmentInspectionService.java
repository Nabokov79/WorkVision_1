package ru.nabokovsg.diagnosedNK.service.common;

import ru.nabokovsg.diagnosedNK.dto.common.equipmentInspection.EquipmentInspectionDto;
import ru.nabokovsg.diagnosedNK.dto.common.equipmentInspection.ResponseEquipmentInspectionDto;

import java.util.List;

public interface EquipmentInspectionService {

    ResponseEquipmentInspectionDto save(EquipmentInspectionDto inspectionDto);

    ResponseEquipmentInspectionDto update(EquipmentInspectionDto inspectionDto);

    List<ResponseEquipmentInspectionDto> getAll(Long id);

    void delete(Long id);
}