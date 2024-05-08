package ru.nabokovsg.diagnosedNK.mapper.measurement.vms;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.parameterMeasurement.ParameterMeasurementDto;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.DefectMeasurement;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.CalculationParameterMeasurement;
import ru.nabokovsg.diagnosedNK.model.norms.MeasuredParameter;

@Mapper(componentModel = "spring")
public interface ParameterMeasurementServiceMapper {

    @Mapping(source = "parameter.parameterName", target = "parameterName")
    @Mapping(source = "parameterDto.minValue", target = "minValue")
    @Mapping(source = "parameterDto.maxValue", target = "maxValue")
    @Mapping(source = "parameter.unitMeasurement", target = "unitMeasurement")
    @Mapping(source = "defect", target = "defectMeasurement")
    @Mapping(target = "id", ignore = true)
    CalculationParameterMeasurement mapToParameterMeasurement(ParameterMeasurementDto parameterDto, DefectMeasurement defect, MeasuredParameter parameter);
}