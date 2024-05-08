package ru.nabokovsg.diagnosedNK.service.measurement.gm;

import ru.nabokovsg.diagnosedNK.dto.measurement.referencePoint.ReferencePointDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.сontrolPoint.ResultControlPoint;
import ru.nabokovsg.diagnosedNK.model.measurement.gm.GeodesicMeasurement;

import java.util.List;

public interface ResultCalculationsMeasurementsGeodesyService {

    void save(Long equipmentId, List<GeodesicMeasurement> measurements);

    void update(Long equipmentId, List<GeodesicMeasurement> measurements);

    List<ReferencePointDto> getResultReferencePoint(Long equipmentId, Long surveyJournalId);

   ResultControlPoint getResultControlPoint(Long equipmentId, Long surveyJournalId);

}