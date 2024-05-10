package ru.nabokovsg.diagnosedNK.service.measurement.vms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.parameterMeasurement.ParameterMeasurementDto;
import ru.nabokovsg.diagnosedNK.exceptions.NotFoundException;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.CalculationParameterMeasurement;
import ru.nabokovsg.diagnosedNK.model.norms.TypeCalculation;
import ru.nabokovsg.diagnosedNK.model.norms.TypeOfParameterCalculation;
import ru.nabokovsg.diagnosedNK.model.norms.MeasuredParameter;
import ru.nabokovsg.diagnosedNK.repository.measurement.vms.ParameterMeasurementServiceRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParameterMeasurementServiceImpl implements ParameterMeasurementService {

    private final ParameterMeasurementServiceRepository repository;
    private final CalculationParameterMeasurementService calculationService;

    @Override
    public Set<CalculationParameterMeasurement> save(TypeCalculation typeCalculation
                                                   , Set<MeasuredParameter> measuredParameters
                                                   , Set<CalculationParameterMeasurement> parameterMeasurements
                                                   , List<ParameterMeasurementDto> parameterMeasurementsDto) {
        return new HashSet<>(repository.saveAll(calculationTypeCalculation(typeCalculation
                                                                         , measuredParameters
                                                                         , parameterMeasurements
                                                                         , parameterMeasurementsDto)));
    }

    public Set<CalculationParameterMeasurement> calculationTypeCalculation(TypeCalculation typeCalculation
                                                            , Set<MeasuredParameter> measuredParameters
                                                            , Set<CalculationParameterMeasurement> parameterMeasurements
                                                            , List<ParameterMeasurementDto> parameterMeasurementsDto) {
        Map<Long, TypeOfParameterCalculation> typeCalculationsDb = measuredParameters
                .stream()
                .collect(Collectors.toMap(MeasuredParameter::getId, MeasuredParameter::getTypeCalculation));
        Map<Long, CalculationParameterMeasurement> parameterMeasurementsDb = parameterMeasurements.stream()
                .collect(Collectors.toMap(CalculationParameterMeasurement::getId, r -> r));
        switch (typeCalculation) {
            case NO_ACTION -> { return parameterMeasurementsDto.stream()
                    .map(p -> calculationByTypeOfParameterCalculation(typeCalculationsDb.get(p.getParameterId())
                                                                    , parameterMeasurementsDb.get(p.getParameterId())
                                                                    , p))
                    .collect(Collectors.toSet());
            }
            case SQUARE -> {
                return calculationService.countSquare(
                         parameterMeasurements.stream()
                                              .collect(Collectors.toMap(CalculationParameterMeasurement::getId, p -> p))
                        , parameterMeasurementsDto.stream()
                                        .collect(Collectors.toMap(p -> parameterMeasurementsDb.get(p.getParameterId())
                                                                                              .getParameterName()
                                                        , p -> p)));
            }
            case QUANTITY -> {
                return calculationService.countQuantity(
                        parameterMeasurements.stream()
                                              .collect(Collectors.toMap(CalculationParameterMeasurement::getId, p -> p))
                        , parameterMeasurementsDto.stream()
                                          .collect(Collectors.toMap(p -> parameterMeasurementsDb.get(p.getParameterId())
                                                                                                .getParameterName()
                                                                          , p -> p)));}
            default -> {return parameterMeasurements;}
        }
    }

    private CalculationParameterMeasurement calculationByTypeOfParameterCalculation(
                                                                    TypeOfParameterCalculation typeCalculation
                                                                  , CalculationParameterMeasurement parameterMeasurement
                                                                  , ParameterMeasurementDto parameterMeasurementDto) {
        switch (typeCalculation) {
            case MIN -> {
                return calculationService.countMin(parameterMeasurement, parameterMeasurementDto);
            }
            case MAX -> {
                return calculationService.countMax(parameterMeasurement, parameterMeasurementDto);
            }
            case MAX_MIN -> {
                return calculationService.countMaxAndMin(parameterMeasurement, parameterMeasurementDto);
            }
            default ->
                  throw new NotFoundException(String.format("Unknown type=%s calculation parameters", typeCalculation));
        }
    }
}