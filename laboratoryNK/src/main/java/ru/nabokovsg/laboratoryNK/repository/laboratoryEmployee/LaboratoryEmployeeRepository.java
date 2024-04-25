package ru.nabokovsg.laboratoryNK.repository.laboratoryEmployee;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.laboratoryEmployee.LaboratoryEmployee;

public interface LaboratoryEmployeeRepository extends JpaRepository<LaboratoryEmployee, Long> {
}