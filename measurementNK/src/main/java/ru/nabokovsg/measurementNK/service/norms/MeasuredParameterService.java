package ru.nabokovsg.measurementNK.service.norms;

import ru.nabokovsg.measurementNK.dto.norms.measuredParameter.MeasuredParameterDto;
import ru.nabokovsg.measurementNK.model.norms.Defect;
import ru.nabokovsg.measurementNK.model.norms.ElementRepair;
import ru.nabokovsg.measurementNK.model.norms.MeasuredParameter;

import java.util.List;
import java.util.Set;

public interface MeasuredParameterService {

    Set<MeasuredParameter> saveForDefect(Defect defect, List<MeasuredParameterDto> parametersDto);

    Set<MeasuredParameter> saveForElementRepair(ElementRepair repair, List<MeasuredParameterDto> parametersDto);

    Set<MeasuredParameter> update(List<MeasuredParameterDto> parametersDto);
}