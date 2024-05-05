package ru.nabokovsg.diagnosedNK.mapper.measurement;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.nabokovsg.diagnosedNK.dto.measurement.сontrolPoint.PointDifferenceDto;
import ru.nabokovsg.diagnosedNK.model.measurement.gm.ControlPoint;
import ru.nabokovsg.diagnosedNK.model.measurement.gm.GeodesicPointType;
import ru.nabokovsg.diagnosedNK.model.measurement.gm.PointDifference;

@Mapper(componentModel = "spring")
public interface PointDifferenceMapper {

    @Mapping(source = "controlPoint.surveyJournalId", target = "surveyJournalId")
    @Mapping(source = "controlPoint.equipmentId", target = "equipmentId")
    @Mapping(source = "geodesicPointType", target = "geodesicPointType")
    @Mapping(source = "firstPlaceNumber", target = "firstPlaceNumber")
    @Mapping(source = "secondPlaceNumber", target = "secondPlaceNumber")
    @Mapping(source = "difference", target = "difference")
    @Mapping(target = "id", ignore = true)
    PointDifference mapToPointDifference(GeodesicPointType geodesicPointType
                                       , ControlPoint controlPoint
                                       , Integer firstPlaceNumber
                                       , Integer secondPlaceNumber
                                       , Integer difference);

    @Mapping(source = "acceptableDeviation", target = "acceptableDeviation")
    @Mapping(target = "id", ignore = true)
    PointDifference mapPointDifferenceWithControlPointMeasurement(@MappingTarget PointDifference pointDifference
                                                                               , Boolean acceptableDeviation);

    PointDifference mapToUpdatePointDifference(@MappingTarget PointDifference pointDifferenceDb
                                                            , PointDifference pointDifference);

    PointDifferenceDto mapToPointDifferenceDto(PointDifference pointDifference);
}