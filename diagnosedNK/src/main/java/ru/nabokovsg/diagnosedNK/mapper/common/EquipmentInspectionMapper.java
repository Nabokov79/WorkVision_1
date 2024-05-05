package ru.nabokovsg.diagnosedNK.mapper.common;

import org.mapstruct.Mapper;
import ru.nabokovsg.diagnosedNK.dto.common.equipmentInspection.EquipmentInspectionDto;
import ru.nabokovsg.diagnosedNK.dto.common.equipmentInspection.ResponseEquipmentInspectionDto;
import ru.nabokovsg.diagnosedNK.model.common.EquipmentInspection;

@Mapper(componentModel = "spring")
public interface EquipmentInspectionMapper {

    EquipmentInspection mapToEquipmentInspection(EquipmentInspectionDto inspectionDto);

    ResponseEquipmentInspectionDto mapToResponseEquipmentInspectionDto(EquipmentInspection inspection);
}