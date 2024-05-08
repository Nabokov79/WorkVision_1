package ru.nabokovsg.diagnosedNK.service.measurement.vms;

import org.springframework.stereotype.Service;
import ru.nabokovsg.diagnosedNK.exceptions.NotFoundException;
import ru.nabokovsg.diagnosedNK.model.common.ConstParameterMeasurement;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.CalculationParameterMeasurement;
import ru.nabokovsg.diagnosedNK.model.norms.ActionsOnParameter;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CalculationParameterMeasurementServiceImpl extends ConstParameterMeasurement implements CalculationParameterMeasurementService {

    @Override
    public Set<CalculationParameterMeasurement> calculationDefectMeasurement(ActionsOnParameter actionsOnParameter
            , List<CalculationParameterMeasurement> parameterMeasurementsDb
            , List<CalculationParameterMeasurement> parameterMeasurements) {
        Map<String, CalculationParameterMeasurement> parameters = parameterMeasurementsDb
                .stream()
                .collect(Collectors.toMap(CalculationParameterMeasurement::getParameterName, r -> r));
        switch (actionsOnParameter) {
            case QUANTITY -> parameters.put(p.getParameterName(), calculationService.countQuantity(parameter, measurement));
            case SQUARE -> countSquare(parameters, measurementsDto, p.getActionsOnParameter());
            case REPLACE -> replace(parameters, measurementsDto);
        }
        return new HashSet<>(parameters.values());
    }

    @Override
    public Set<CalculationParameterMeasurement> calculationParameterMeasurement(ActionsOnParameter actionsOnParameter
            , List<CalculationParameterMeasurement> parameterMeasurementsDb
            , List<CalculationParameterMeasurement> parameterMeasurements) {
        Set<CalculationParameterMeasurement> calculationParameters = new HashSet<>();
        switch (actionsOnParameter) {
            case MIN -> calculationParameters.add(p.getParameterName(), countMin(parameter, measurement));
            case MAX -> calculationParameters.add(p.getParameterName(), countMax(parameter, measurement));
            case MAX_MIN -> calculationParameters.add(p.getParameterName(), countMax(calculationService.countMin(parameter, measurement), measurement));
            case REPLACE -> {return new HashSet<>(parameterMeasurements);}
        }
        return calculationParameters;
    }

    @Override
    public void replace(List<CalculationParameterMeasurement> parameterMeasurementsDb
            , List<CalculationParameterMeasurement> parameterMeasurements) {
        Map<Long, CalculationParameterMeasurement> parameters = parameterMeasurementsDb.stream().collect(Collectors.toMap(CalculationParameterMeasurement::getId, p -> p));
        parameters.tParameterName().equals(getQuantity())) {
                countQuantity(p, parametersDto.get(p.getParameterName()));
            } else {
                p.setParameterValue(parametersDto.get(p.getParameterName()));
            }
        });
    }

    @Override
    public CalculationParameterMeasurement countMin(List<CalculationParameterMeasurement> parameterMeasurementsDb
                                                  , List<CalculationParameterMeasurement> parameterMeasurements) {
        if (measurement == null) {
            throw new NotFoundException(
                    String.format("To calculate the minimum" +
                            ", the measured value must not be zero, measurement=%s", measurement)
            );
        }
        if (parameter.getMinValue() == null || parameter.getMinValue() > measurement) {
            parameter.setMinValue(measurement);
        }
        return parameter;
    }

    public CalculationParameterMeasurement countMax(ResultParameterMeasurement parameter, Double measurement) {
        if (measurement == null) {
            throw new NotFoundException(
                    String.format("To calculate the maximum" +
                            ", the measured value must not be zero, measurement=%s", measurement)
            );
        }
        if (parameter.getMaxValue() == null || parameter.getMaxValue() < measurement) {
            parameter.setMaxValue(measurement);
        }
        return parameter;
    }

    @Override
    public CalculationParameterMeasurement countQuantity(ResultParameterMeasurement parameter, Double measurement) {
        if (measurement != null) {
            if (parameter.getParameterValue() != null) {
                parameter.setParameterValue(parameter.getParameterValue() + measurement);
            } else {
                parameter.setParameterValue(measurement);
            }
        } else {
            if (parameter.getParameterValue() == null) {
                parameter.setParameterValue(1.0);
            } else {
                parameter.setParameterValue(parameter.getParameterValue() + 1);
            }
        }
        return parameter;
    }

    @Override
    public void countSquare(Map<String, CalculationParameterMeasurement> parameters, Map<String, Double> parametersDto, ActionsOnParameter action) {
        CalculationParameterMeasurement parameter = parameters.get(getSquare());
        Double square = parametersDto.get(getSquare());
          if (square == null) {
            if (parametersDto.get(getLength()) != null) {
                if (parametersDto.get(getWidth()) != null) {
                    square = parametersDto.get(getLength()) * parametersDto.get(getWidth());
                }
                if (parameters.get(getHeight()) != null && parametersDto.get(getWidth()) == null) {
                    square = parametersDto.get(getLength()) * parametersDto.get(getHeight());
                }
            }
            if (parametersDto.get(getDiameter()) != null) {
                double rad = parametersDto.get(getDiameter()) / 2;
                if (parametersDto.get(getHeight()) != null) {
                    square = 2 * Math.PI * rad * parametersDto.get(getHeight()) * 100 / 100;
                } else {
                    square = Math.PI * rad * rad * 100 / 100;
                }
            }
            if (square != null && parameter.getUnitMeasurement().equals(getM2())) {
                square /= 1000000;
            }
        }
          switch (action) {
              case SQUARE -> parameter.setParameterValue(square);
              case MIN_SQUARE -> countMin(parameter, square);
              case MAX_SQUARE -> countMax(parameter, square);
              case MIN_MAX_SQUARE -> {
                  countMin(parameter, square);
                  countMax(parameter, square);
              }
          }
        parameters.put(parameter.getParameterName(), parameter);
    }
}