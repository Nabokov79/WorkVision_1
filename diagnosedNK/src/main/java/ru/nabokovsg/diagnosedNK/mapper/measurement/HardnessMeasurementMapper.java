package ru.nabokovsg.diagnosedNK.mapper.measurement;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.nabokovsg.diagnosedNK.dto.measurement.hardnessMeasurement.HardnessMeasurementDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.hardnessMeasurement.ResponseHardnessMeasurementDto;
import ru.nabokovsg.diagnosedNK.model.measurement.HardnessMeasurement;


@Mapper(componentModel = "spring")
public interface HardnessMeasurementMapper {

    @Mapping(source = "measurementDto.surveyJournalId", target = "surveyJournalId")
    @Mapping(source = "measurementDto.equipmentId", target = "equipmentId")
    @Mapping(source = "measurementDto.elementId", target = "elementId")
    @Mapping(source = "measurementDto.partElementId", target = "partElementId")
    @Mapping(source = "measurementDto.measurementNumber", target = "measurementNumber")
    @Mapping(source = "measurementDto.measurementValue", target = "measurementValue")
    @Mapping(source = "measurementDto.id", target = "id")
    HardnessMeasurement mapToHardnessMeasurement(HardnessMeasurementDto measurementDto);

    ResponseHardnessMeasurementDto mapToResponseHardnessMeasurementDto(HardnessMeasurement measurement);


    @Mapping(source = "acceptableValue", target = "acceptableValue")
    HardnessMeasurement mapHardnessMeasurementWithAcceptableValue(@MappingTarget HardnessMeasurement measurement
                                                                               , Boolean acceptableValue);
}