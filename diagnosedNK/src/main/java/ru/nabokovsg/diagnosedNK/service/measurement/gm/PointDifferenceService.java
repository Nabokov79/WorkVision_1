package ru.nabokovsg.diagnosedNK.service.measurement.gm;

import ru.nabokovsg.diagnosedNK.dto.measurement.сontrolPoint.PointDifferenceDto;
import ru.nabokovsg.diagnosedNK.model.measurement.gm.ControlPoint;
import ru.nabokovsg.diagnosedNK.model.norms.AcceptableDeviationsGeodesy;

import java.util.List;
import java.util.Set;

public interface PointDifferenceService {

    void save(AcceptableDeviationsGeodesy acceptableDeviationsGeodesy, Set<ControlPoint> controlPoints);

    void update(AcceptableDeviationsGeodesy acceptableDeviationsGeodesy, Set<ControlPoint> controlPoints);

    List<PointDifferenceDto> getAll(Long equipmentId, Long surveyJournalId);
}