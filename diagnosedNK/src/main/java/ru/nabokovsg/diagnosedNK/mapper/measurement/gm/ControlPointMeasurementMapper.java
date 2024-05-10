package ru.nabokovsg.diagnosedNK.mapper.measurement.gm;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.nabokovsg.diagnosedNK.dto.measurement.сontrolPoint.ControlPointDto;
import ru.nabokovsg.diagnosedNK.model.measurement.gm.ControlPoint;
import ru.nabokovsg.diagnosedNK.model.measurement.gm.GeodesicMeasurement;

@Mapper(componentModel = "spring")
public interface ControlPointMeasurementMapper {

    @Mapping(source = "measurement.surveyJournalId", target = "surveyJournalId")
    @Mapping(source = "measurement.equipmentId", target = "equipmentId")
    @Mapping(source = "measurement.numberMeasurementLocation", target = "placeNumber")
    @Mapping(source = "measurement.controlPointValue", target = "calculatedHeight")
    @Mapping(source = "deviation", target = "deviation")
    @Mapping(target = "id", ignore = true)
    ControlPoint mapToControlPoint(GeodesicMeasurement measurement, Integer deviation);

    @Mapping(source = "measurement.surveyJournalId", target = "surveyJournalId")
    @Mapping(source = "measurement.equipmentId", target = "equipmentId")
    @Mapping(source = "measurement.numberMeasurementLocation", target = "placeNumber")
    @Mapping(source = "measurement.controlPointValue", target = "calculatedHeight")
    @Mapping(source = "deviation", target = "deviation")
    @Mapping(target = "id", ignore = true)
    ControlPoint mapToUpdateControlPoint(@MappingTarget ControlPoint point
                                                      , GeodesicMeasurement measurement
                                                      , Integer deviation);

    ControlPointDto mapToControlPointDto(ControlPoint point);
}