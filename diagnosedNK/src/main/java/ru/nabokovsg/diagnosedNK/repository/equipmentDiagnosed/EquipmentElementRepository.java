package ru.nabokovsg.diagnosedNK.repository.equipmentDiagnosed;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.EquipmentElement;

import java.util.Set;

public interface EquipmentElementRepository extends JpaRepository<EquipmentElement, Long> {

    Set<EquipmentElement> findAllByEquipmentId(Long id);
}