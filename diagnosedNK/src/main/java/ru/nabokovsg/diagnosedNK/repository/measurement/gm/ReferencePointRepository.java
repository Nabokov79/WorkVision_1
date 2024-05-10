package ru.nabokovsg.diagnosedNK.repository.measurement.gm;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.diagnosedNK.model.measurement.gm.ReferencePoint;
import java.util.Set;

public interface ReferencePointRepository extends JpaRepository<ReferencePoint, Long> {

    Set<ReferencePoint> findAllBySurveyJournalIdAndEquipmentId(Long surveyJournalId, Long equipmentId);
}