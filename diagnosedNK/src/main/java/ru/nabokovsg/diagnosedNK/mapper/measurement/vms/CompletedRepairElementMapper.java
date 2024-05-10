package ru.nabokovsg.diagnosedNK.mapper.measurement.vms;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.completedRepairElement.CompletedRepairElementDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.completedRepairElement.ResponseCompletedRepairElementDto;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.CompletedRepairElement;
import ru.nabokovsg.diagnosedNK.model.norms.ElementRepair;

@Mapper(componentModel = "spring")
public interface CompletedRepairElementMapper {

    @Mapping(source = "completedRepairDto.surveyJournalId", target = "surveyJournalId")
    @Mapping(source = "completedRepairDto.elementId", target = "elementId")
    @Mapping(source = "completedRepairDto.partElementId", target = "partElementId")
    @Mapping(source = "elementRepair.id", target = "repairId")
    @Mapping(source = "elementRepair.repairName", target = "repairName")
    @Mapping(source = "completedRepairDto.id", target = "id")
    @Mapping(target = "parameterMeasurements", ignore = true)
    CompletedRepairElement mapToCompletedRepairElement(CompletedRepairElementDto completedRepairDto
                                                    , ElementRepair elementRepair);

    ResponseCompletedRepairElementDto mapToResponseCompletedRepairElementDto(CompletedRepairElement repair);
}