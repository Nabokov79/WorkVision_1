package ru.nabokovsg.diagnosedNK.service.measurement.vms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.parameterMeasurement.ParameterMeasurementDto;
import ru.nabokovsg.diagnosedNK.mapper.measurement.vms.ParameterMeasurementServiceMapper;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.DefectMeasurement;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.CalculationParameterMeasurement;
import ru.nabokovsg.diagnosedNK.model.norms.ActionsOnParameter;
import ru.nabokovsg.diagnosedNK.model.norms.MeasuredParameter;
import ru.nabokovsg.diagnosedNK.repository.measurement.vms.ParameterMeasurementServiceRepository;
import ru.nabokovsg.diagnosedNK.service.norms.MeasuredParameterService;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParameterMeasurementServiceImpl implements ParameterMeasurementService {

    private final ParameterMeasurementServiceRepository repository;
    private final ParameterMeasurementServiceMapper mapper;
    private final MeasuredParameterService measuredParameterService;
    private final CalculationParameterMeasurementService calculationService;

    @Override
    public Set<CalculationParameterMeasurement> save(ActionsOnParameter actionsOnParameter
                                                   , DefectMeasurement defectMeasurement
                                                   , List<ParameterMeasurementDto> parameterMeasurementsDto) {
        Map<Long, MeasuredParameter> measuredParameters = measuredParameterService.getAllByDefectId(
                                                                                        defectMeasurement.getDefectId())
                                                           .stream()
                                                           .collect(Collectors.toMap(MeasuredParameter::getId, m -> m));
        Set<CalculationParameterMeasurement> parameterMeasurements = calculationService.calculation(actionsOnParameter, defectMeasurement.getParameterMeasurements(), parameterMeasurementsDto.stream()
                .map( p -> mapper.mapToParameterMeasurement(p
                        , defectMeasurement
                        , measuredParameters.get(p.getParameterId())))
                .toList());
        return null;
    }

    public Set<CalculationParameterMeasurement> calculation(ActionsOnParameter actionsOnParameter
                                                       , List<CalculationParameterMeasurement> parameterMeasurementsDb
                                                       , List<CalculationParameterMeasurement> parameterMeasurements) {
        Map<String, CalculationParameterMeasurement> parameters = parameterMeasurementsDb
                                          .stream()
                                          .collect(Collectors.toMap(CalculationParameterMeasurement::getParameterName, r -> r));
            switch (actionsOnParameter) {
                case MIN -> parameters.put(p.getParameterName(), calculationService.countMin(parameter, measurement));
                case MAX -> parameters.put(p.getParameterName(), calculationService.countMax(parameter, measurement));
                case MAX_MIN -> parameters.put(p.getParameterName(), calculationService.countMax(calculationService.countMin(parameter, measurement), measurement));
                case QUANTITY -> parameters.put(p.getParameterName(), calculationService.countQuantity(parameter, measurement));
                case SQUARE -> calculationService.countSquare(parameters, measurementsDto, p.getActionsOnParameter());
                case NO_ACTION -> calculationService.replace(parameters, measurementsDto);
            }
        return new HashSet<>(parameters.values());
    }
}