package ru.nabokovsg.laboratoryNK.repository.equipmentDiagnosed;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.equipmentDiagnosed.EquipmentPassport;

public interface EquipmentPassportRepository extends JpaRepository<EquipmentPassport, Long> {

    EquipmentPassport findByHeaderAndEquipmentId(String header, Long equipmentId);
}