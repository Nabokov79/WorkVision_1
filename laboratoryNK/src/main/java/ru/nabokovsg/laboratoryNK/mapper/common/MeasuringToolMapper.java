package ru.nabokovsg.laboratoryNK.mapper.common;

import org.mapstruct.Mapper;
import ru.nabokovsg.laboratoryNK.dto.common.measuringTool.MeasuringToolDto;
import ru.nabokovsg.laboratoryNK.dto.common.measuringTool.ResponseMeasuringToolDto;
import ru.nabokovsg.laboratoryNK.dto.common.measuringTool.SearchParameters;
import ru.nabokovsg.laboratoryNK.model.common.MeasuringTool;

@Mapper(componentModel = "spring")
public interface MeasuringToolMapper {

    MeasuringTool mapToMeasuringTool(MeasuringToolDto measuringToolDto);

    ResponseMeasuringToolDto mapToResponseMeasuringToolDto(MeasuringTool newMeasuringTool);

    SearchParameters mapToRequestParameters(MeasuringToolDto measuringToolDto);
}