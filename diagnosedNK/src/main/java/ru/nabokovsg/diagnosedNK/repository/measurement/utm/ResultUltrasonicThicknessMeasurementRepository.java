package ru.nabokovsg.diagnosedNK.repository.measurement.utm;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.diagnosedNK.model.measurement.utm.ResultUltrasonicThicknessMeasurement;

public interface ResultUltrasonicThicknessMeasurementRepository extends JpaRepository<ResultUltrasonicThicknessMeasurement, Long> {
}