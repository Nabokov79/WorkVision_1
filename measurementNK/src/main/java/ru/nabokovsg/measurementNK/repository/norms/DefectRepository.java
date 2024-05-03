package ru.nabokovsg.measurementNK.repository.norms;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.measurementNK.model.norms.Defect;

public interface DefectRepository extends JpaRepository<Defect, Long> {

    Defect findByDefectName(String defectName);
}