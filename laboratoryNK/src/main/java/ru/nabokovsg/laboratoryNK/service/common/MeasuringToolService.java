package ru.nabokovsg.laboratoryNK.service.common;

import ru.nabokovsg.laboratoryNK.dto.common.measuringTool.MeasuringToolDto;
import ru.nabokovsg.laboratoryNK.dto.common.measuringTool.ResponseMeasuringToolDto;
import ru.nabokovsg.laboratoryNK.dto.common.measuringTool.SearchParameters;
import ru.nabokovsg.laboratoryNK.model.common.MeasuringTool;
import ru.nabokovsg.laboratoryNK.model.laboratoryEmployee.LaboratoryEmployee;
import ru.nabokovsg.laboratoryNK.model.template.MeasuringToolTemplate;

import java.util.List;
import java.util.Set;

public interface MeasuringToolService {

    ResponseMeasuringToolDto save(MeasuringToolDto measuringToolDto);

    ResponseMeasuringToolDto update(MeasuringToolDto measuringToolDto);

    List<ResponseMeasuringToolDto> getAll(SearchParameters parameters);

    void delete(Long id);

    List<MeasuringTool> getByLaboratoryEmployeeDataAndTemplate(Set<LaboratoryEmployee> employees
                                                             , List<MeasuringToolTemplate> measuringToolsTemplates);
}