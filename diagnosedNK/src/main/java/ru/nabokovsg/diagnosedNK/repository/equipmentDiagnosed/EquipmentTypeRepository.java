package ru.nabokovsg.diagnosedNK.repository.equipmentDiagnosed;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.EquipmentType;

public interface EquipmentTypeRepository extends JpaRepository<EquipmentType, Long> {

    EquipmentType findByEquipmentNameAndModel(String equipmentName, String model);
}