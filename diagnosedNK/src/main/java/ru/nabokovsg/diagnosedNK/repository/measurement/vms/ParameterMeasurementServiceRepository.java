package ru.nabokovsg.diagnosedNK.repository.measurement.vms;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.CalculationParameterMeasurement;

public interface ParameterMeasurementServiceRepository extends JpaRepository<CalculationParameterMeasurement, Long> {
}