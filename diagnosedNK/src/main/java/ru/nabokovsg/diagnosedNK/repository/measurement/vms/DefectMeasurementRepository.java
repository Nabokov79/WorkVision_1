package ru.nabokovsg.diagnosedNK.repository.measurement.vms;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.DefectMeasurement;

import java.util.Set;

public interface DefectMeasurementRepository extends JpaRepository<DefectMeasurement, Long> {

    Set<DefectMeasurement> findAllByVisualMeasuringSurveyEquipmentDiagnosedTaskJournalId(Long taskJournalId);
}