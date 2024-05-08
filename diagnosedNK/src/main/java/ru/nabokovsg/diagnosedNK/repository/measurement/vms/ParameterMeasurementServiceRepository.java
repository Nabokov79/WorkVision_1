package ru.nabokovsg.diagnosedNK.repository.measurement.vms;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.diagnosedNK.service.measurement.vms.ParameterMeasurementService;

public interface ParameterMeasurementServiceRepository extends JpaRepository<ParameterMeasurementService, Long> {
}