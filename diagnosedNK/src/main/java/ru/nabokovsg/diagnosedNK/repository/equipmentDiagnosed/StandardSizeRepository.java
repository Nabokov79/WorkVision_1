package ru.nabokovsg.diagnosedNK.repository.equipmentDiagnosed;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.StandardSize;

public interface StandardSizeRepository extends JpaRepository<StandardSize, Long> {
}