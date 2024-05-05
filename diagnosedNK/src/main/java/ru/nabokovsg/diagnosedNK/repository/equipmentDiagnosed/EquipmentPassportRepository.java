package ru.nabokovsg.diagnosedNK.repository.equipmentDiagnosed;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.EquipmentPassport;

public interface EquipmentPassportRepository extends JpaRepository<EquipmentPassport, Long> {

    EquipmentPassport findByHeaderAndEquipmentId(String header, Long equipmentId);
}