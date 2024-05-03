package ru.nabokovsg.measurementNK.mapper.common;

import org.mapstruct.Mapper;
import ru.nabokovsg.measurementNK.dto.common.equipmentInspection.EquipmentInspectionDto;
import ru.nabokovsg.measurementNK.dto.common.equipmentInspection.ResponseEquipmentInspectionDto;
import ru.nabokovsg.measurementNK.model.common.EquipmentInspection;

@Mapper(componentModel = "spring")
public interface EquipmentInspectionMapper {

    EquipmentInspection mapToEquipmentInspection(EquipmentInspectionDto inspectionDto);

    ResponseEquipmentInspectionDto mapToResponseEquipmentInspectionDto(EquipmentInspection inspection);
}