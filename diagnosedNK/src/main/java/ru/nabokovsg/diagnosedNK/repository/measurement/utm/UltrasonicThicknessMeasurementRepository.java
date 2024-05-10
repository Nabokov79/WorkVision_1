package ru.nabokovsg.diagnosedNK.repository.measurement.utm;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.diagnosedNK.model.measurement.utm.UltrasonicThicknessMeasurement;

import java.util.Set;

public interface UltrasonicThicknessMeasurementRepository extends JpaRepository<UltrasonicThicknessMeasurement, Long> {

    Set<UltrasonicThicknessMeasurement> findAllBySurveyJournalId(Long surveyJournalId);
}