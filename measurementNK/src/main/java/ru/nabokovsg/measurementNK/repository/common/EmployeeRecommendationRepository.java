package ru.nabokovsg.measurementNK.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.measurementNK.model.common.EmployeeRecommendation;

import java.util.Set;

public interface EmployeeRecommendationRepository extends JpaRepository<EmployeeRecommendation, Long> {

    EmployeeRecommendation findByEquipmentIdAndRecommendationText(Long equipmentId,  String recommendationText);

    Set<EmployeeRecommendation> findAllByEquipmentId(Long equipmentId);
}