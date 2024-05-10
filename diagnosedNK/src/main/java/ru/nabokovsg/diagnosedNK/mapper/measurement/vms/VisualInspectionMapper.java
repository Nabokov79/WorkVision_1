package ru.nabokovsg.diagnosedNK.mapper.measurement.vms;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.visualInspection.ResponseVisualInspectionDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.visualInspection.VisualInspectionDto;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.VisualInspection;

@Mapper(componentModel = "spring")
public interface VisualInspectionMapper {

    @Mapping(source = "inspectionDto.surveyJournalId", target = "surveyJournalId")
    @Mapping(source = "inspectionDto.equipmentId", target = "equipmentId")
    @Mapping(source = "inspectionDto.elementId", target = "elementId")
    @Mapping(source = "inspectionDto.inspection", target = "inspection")
    @Mapping(source = "inspectionDto.id", target = "id")
    VisualInspection mapToVisualInspection(VisualInspectionDto inspectionDto);

    ResponseVisualInspectionDto mapToResponseVisualInspectionDto(VisualInspection visualInspection);
}