package ru.nabokovsg.measurementNK.repository.norms;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.measurementNK.model.norms.AcceptableHardness;

import java.util.Set;

public interface AcceptableHardnessRepository extends JpaRepository<AcceptableHardness, Long> {

    AcceptableHardness findByEquipmentTypeIdAndElementId(Long equipmentTypeId,  Long elementId);

    Set<AcceptableHardness> findAllByEquipmentTypeId(Long equipmentTypeId);
}