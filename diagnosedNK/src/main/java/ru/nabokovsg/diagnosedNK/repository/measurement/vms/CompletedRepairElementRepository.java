package ru.nabokovsg.diagnosedNK.repository.measurement.vms;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.CompletedRepairElement;

import java.util.Set;

public interface CompletedRepairElementRepository extends JpaRepository<CompletedRepairElement, Long> {

    Set<CompletedRepairElement> findAllBySurveyJournalId(Long surveyJournalId);
}