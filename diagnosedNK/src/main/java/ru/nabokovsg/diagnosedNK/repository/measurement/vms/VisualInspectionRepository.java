package ru.nabokovsg.diagnosedNK.repository.measurement.vms;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.VisualInspection;

import java.util.Set;

public interface VisualInspectionRepository extends JpaRepository<VisualInspection, Long> {

    Set<VisualInspection> findAllBySurveyJournalId(Long surveyJournalId);
}