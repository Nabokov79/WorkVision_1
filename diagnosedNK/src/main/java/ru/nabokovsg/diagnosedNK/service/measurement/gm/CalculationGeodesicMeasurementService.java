package ru.nabokovsg.diagnosedNK.service.measurement.gm;

import ru.nabokovsg.diagnosedNK.model.measurement.gm.DeviationYear;

import java.util.List;

public interface CalculationGeodesicMeasurementService {

    Integer getMinMeasurement(List<Integer> calculatedHeights);

    Integer getDeviation(Integer min, Integer calculatedHeight);

    Integer getPrecipitation(Integer newDeviation, List<DeviationYear> deviationYears);
}