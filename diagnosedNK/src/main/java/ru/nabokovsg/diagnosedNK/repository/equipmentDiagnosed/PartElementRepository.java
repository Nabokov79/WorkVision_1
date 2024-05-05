package ru.nabokovsg.diagnosedNK.repository.equipmentDiagnosed;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.PartElement;

import java.util.Set;

public interface PartElementRepository extends JpaRepository<PartElement, Long> {

    PartElement findByElementIdAndPartName(Long elementId, String partName);

    Set<PartElement> findAllByElementId(Long elementId);
}