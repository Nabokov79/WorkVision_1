package ru.nabokovsg.measurementNK.repository.norms;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.measurementNK.model.norms.AcceptableThickness;

import java.util.Set;

public interface AcceptableThicknessRepository extends JpaRepository<AcceptableThickness, Long> {

    Set<AcceptableThickness> findAllByEquipmentTypeId(Long equipmentTypeId);
}