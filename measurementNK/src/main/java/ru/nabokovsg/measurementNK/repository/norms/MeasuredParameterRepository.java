package ru.nabokovsg.measurementNK.repository.norms;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.measurementNK.model.norms.MeasuredParameter;

public interface MeasuredParameterRepository extends JpaRepository<MeasuredParameter, Long> {
}