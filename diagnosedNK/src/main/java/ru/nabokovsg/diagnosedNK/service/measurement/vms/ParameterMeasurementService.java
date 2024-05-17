package ru.nabokovsg.diagnosedNK.service.measurement.vms;

import ru.nabokovsg.diagnosedNK.dto.measurement.vms.parameterMeasurement.ParameterMeasurementDto;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.CalculationParameterMeasurement;
import ru.nabokovsg.diagnosedNK.model.norms.MeasuredParameter;
import ru.nabokovsg.diagnosedNK.model.norms.TypeCalculation;

import java.util.List;
import java.util.Set;

public interface ParameterMeasurementService {

    Set<CalculationParameterMeasurement> save(TypeCalculation typeCalculation
                                            , Set<MeasuredParameter> measuredParameters
                                            , Set<CalculationParameterMeasurement> parameterMeasurements
                                            , List<ParameterMeasurementDto> parameterMeasurementsDto);

    Set<CalculationParameterMeasurement> update(TypeCalculation typeCalculation
            , Set<MeasuredParameter> measuredParameters
            , Set<CalculationParameterMeasurement> parameterMeasurements
            , List<ParameterMeasurementDto> parameterMeasurementsDto);
}