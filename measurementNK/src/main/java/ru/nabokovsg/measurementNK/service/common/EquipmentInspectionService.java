package ru.nabokovsg.measurementNK.service.common;

import ru.nabokovsg.measurementNK.dto.common.equipmentInspection.EquipmentInspectionDto;
import ru.nabokovsg.measurementNK.dto.common.equipmentInspection.ResponseEquipmentInspectionDto;

import java.util.List;

public interface EquipmentInspectionService {

    ResponseEquipmentInspectionDto save(EquipmentInspectionDto inspectionDto);

    ResponseEquipmentInspectionDto update(EquipmentInspectionDto inspectionDto);

    List<ResponseEquipmentInspectionDto> getAll(Long id);

    void delete(Long id);
}