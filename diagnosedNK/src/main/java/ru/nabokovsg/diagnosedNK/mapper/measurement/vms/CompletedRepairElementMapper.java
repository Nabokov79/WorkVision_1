package ru.nabokovsg.diagnosedNK.mapper.measurement.vms;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.completedRepairElement.CompletedRepairElementDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.completedRepairElement.ResponseCompletedRepairElementDto;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.EquipmentElement;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.PartElement;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.CompletedRepairElement;
import ru.nabokovsg.diagnosedNK.model.norms.ElementRepair;

@Mapper(componentModel = "spring")
public interface CompletedRepairElementMapper {

    @Mapping(source = "completedRepairDto.surveyJournalId", target = "surveyJournalId")
    @Mapping(source = "element.id", target = "elementId")
    @Mapping(source = "element.elementName", target = "elementName")
    @Mapping(source = "elementRepair.id", target = "repairId")
    @Mapping(source = "elementRepair.repairName", target = "repairName")
    @Mapping(source = "completedRepairDto.id", target = "id")
    @Mapping(target = "parameterMeasurements", ignore = true)
    CompletedRepairElement mapWithEquipmentElement(CompletedRepairElementDto completedRepairDto
                                                    , ElementRepair elementRepair
                                                    , EquipmentElement element);

    @Mapping(source = "partElement.id", target = "partElementId")
    @Mapping(source = "partElement.partName", target = "partName")
    CompletedRepairElement mapWithPartElement(@MappingTarget CompletedRepairElement repair, PartElement partElement);

    ResponseCompletedRepairElementDto mapToResponseCompletedRepairElementDto(CompletedRepairElement repair);
}