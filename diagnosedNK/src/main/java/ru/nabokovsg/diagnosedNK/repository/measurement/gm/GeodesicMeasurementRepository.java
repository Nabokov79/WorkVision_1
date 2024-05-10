package ru.nabokovsg.diagnosedNK.repository.measurement.gm;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.diagnosedNK.model.measurement.gm.GeodesicMeasurement;

import java.util.Set;

public interface GeodesicMeasurementRepository extends JpaRepository<GeodesicMeasurement, Long> {

    Set<GeodesicMeasurement> findAllByEquipmentId(Long equipmentId);

    Set<GeodesicMeasurement> findAllBySurveyJournalIdAndEquipmentId(Long surveyJournalId, Long equipmentId);
}