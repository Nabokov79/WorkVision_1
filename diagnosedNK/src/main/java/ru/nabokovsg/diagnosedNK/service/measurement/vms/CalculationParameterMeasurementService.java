package ru.nabokovsg.diagnosedNK.service.measurement.vms;

import ru.nabokovsg.diagnosedNK.model.measurement.vms.CalculationParameterMeasurement;
import ru.nabokovsg.diagnosedNK.model.norms.ActionsOnParameter;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CalculationParameterMeasurementService {

    Set<CalculationParameterMeasurement> calculationDefectMeasurement(ActionsOnParameter actionsOnParameter
            , List<CalculationParameterMeasurement> parameterMeasurementsDb
            , List<CalculationParameterMeasurement> parameterMeasurements);
    Set<CalculationParameterMeasurement> calculationParameterMeasurement(ActionsOnParameter actionsOnParameter
            , List<CalculationParameterMeasurement> parameterMeasurementsDb
            , List<CalculationParameterMeasurement> parameterMeasurements);
    void replace(Map<String, ResultParameterMeasurement> parameters, Map<String, Double> parametersDto);
    CalculationParameterMeasurement countMin(ResultParameterMeasurement parameter, Double measurement);

    CalculationParameterMeasurement countMax(ResultParameterMeasurement parameter, Double measurement);

    CalculationParameterMeasurement countQuantity(ResultParameterMeasurement parameter, Double measurement);

    void countSquare(Map<String, CalculationParameterMeasurement> parameters, Map<String, Double> parametersDto, ActionsOnParameter action);
}