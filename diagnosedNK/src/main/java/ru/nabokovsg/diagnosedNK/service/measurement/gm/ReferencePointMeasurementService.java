package ru.nabokovsg.diagnosedNK.service.measurement.gm;

import ru.nabokovsg.diagnosedNK.dto.measurement.referencePoint.ReferencePointDto;
import ru.nabokovsg.diagnosedNK.model.measurement.gm.GeodesicMeasurement;
import ru.nabokovsg.diagnosedNK.model.norms.AcceptableDeviationsGeodesy;

import java.util.List;

public interface ReferencePointMeasurementService {

    void save(AcceptableDeviationsGeodesy acceptableDeviationsGeodesy, List<GeodesicMeasurement> measurements);

    void update(AcceptableDeviationsGeodesy acceptableDeviationsGeodesy, List<GeodesicMeasurement> measurements);

    List<ReferencePointDto> getAll(Long equipmentId, Long surveyJournalId);
}