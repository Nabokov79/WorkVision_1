package ru.nabokovsg.diagnosedNK.service.measurement.vms;

import ru.nabokovsg.diagnosedNK.dto.measurement.vms.parameterMeasurement.ParameterMeasurementDto;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.DefectMeasurement;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.CalculationParameterMeasurement;
import ru.nabokovsg.diagnosedNK.model.norms.ActionsOnParameter;

import java.util.List;
import java.util.Set;

public interface ParameterMeasurementService {

    Set<CalculationParameterMeasurement> save(ActionsOnParameter actionsOnParameter
                                            , DefectMeasurement defectMeasurement
                                            , List<ParameterMeasurementDto> parameterMeasurementsDto);
}