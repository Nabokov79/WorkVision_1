package ru.nabokovsg.diagnosedNK.repository.measurement;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.diagnosedNK.model.measurement.HardnessMeasurement;

import java.util.Set;

public interface HardnessMeasurementRepository extends JpaRepository<HardnessMeasurement, Long> {

    Set<HardnessMeasurement> findAllBySurveyJournalIdAndEquipmentId(Long surveyJournalId, Long equipmentId);

    Set<HardnessMeasurement> findAllBySurveyJournalId(Long surveyJournalId);
}