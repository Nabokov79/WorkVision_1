package ru.nabokovsg.laboratoryNK.service.common;

import ru.nabokovsg.laboratoryNK.dto.common.measuringTool.MeasuringToolDto;
import ru.nabokovsg.laboratoryNK.dto.common.measuringTool.ResponseMeasuringToolDto;
import ru.nabokovsg.laboratoryNK.dto.common.measuringTool.SearchParameters;

import java.util.List;

public interface MeasuringToolService {

    ResponseMeasuringToolDto save(MeasuringToolDto measuringToolDto);

    ResponseMeasuringToolDto update(MeasuringToolDto measuringToolDto);

    List<ResponseMeasuringToolDto> getAll(SearchParameters parameters);

    void delete(Long id);
}