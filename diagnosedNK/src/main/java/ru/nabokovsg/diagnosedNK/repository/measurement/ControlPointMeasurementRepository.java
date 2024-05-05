package ru.nabokovsg.diagnosedNK.repository.measurement;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.diagnosedNK.model.measurement.gm.ControlPoint;

import java.util.Set;

public interface ControlPointMeasurementRepository extends JpaRepository<ControlPoint, Long> {

    Set<ControlPoint> findAllBySurveyJournalIdAndEquipmentId(Long surveyJournalId, Long equipmentId);
}