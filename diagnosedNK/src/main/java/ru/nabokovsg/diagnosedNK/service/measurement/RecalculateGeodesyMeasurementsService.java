package ru.nabokovsg.diagnosedNK.service.measurement;

import ru.nabokovsg.diagnosedNK.model.measurement.gm.GeodesicMeasurement;

import java.util.List;

public interface RecalculateGeodesyMeasurementsService {

    List<GeodesicMeasurement> recalculateByTransition(List<GeodesicMeasurement> geodesicMeasurements);
}