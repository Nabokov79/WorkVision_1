package ru.nabokovsg.diagnosedNK.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.diagnosedNK.model.common.EquipmentInspection;

import java.util.Set;

public interface EquipmentInspectionRepository extends JpaRepository<EquipmentInspection, Long> {

    Set<EquipmentInspection> findAllByEquipmentDiagnosedId(Long equipmentDiagnosedId);
}