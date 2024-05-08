package ru.nabokovsg.diagnosedNK.service.measurement.gm;

import ru.nabokovsg.diagnosedNK.dto.measurement.сontrolPoint.ControlPointDto;
import ru.nabokovsg.diagnosedNK.model.measurement.gm.ControlPoint;
import ru.nabokovsg.diagnosedNK.model.measurement.gm.GeodesicMeasurement;

import java.util.List;
import java.util.Set;

public interface ControlPointMeasurementService {

    Set<ControlPoint> save(List<GeodesicMeasurement> measurements);

    Set<ControlPoint> update(List<GeodesicMeasurement> measurements);

    List<ControlPointDto> getAll(Long equipmentId, Long surveyJournalId);
}