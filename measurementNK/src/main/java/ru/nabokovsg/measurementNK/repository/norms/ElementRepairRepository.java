package ru.nabokovsg.measurementNK.repository.norms;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.measurementNK.model.norms.ElementRepair;

public interface ElementRepairRepository extends JpaRepository<ElementRepair, Long> {

    ElementRepair findByRepairName(String repairName);
}