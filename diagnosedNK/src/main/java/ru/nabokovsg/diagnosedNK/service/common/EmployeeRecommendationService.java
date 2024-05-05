package ru.nabokovsg.diagnosedNK.service.common;

import ru.nabokovsg.diagnosedNK.dto.common.employeeRecommendation.EmployeeRecommendationDto;
import ru.nabokovsg.diagnosedNK.dto.common.employeeRecommendation.ResponseEmployeeRecommendationDto;

import java.util.List;

public interface EmployeeRecommendationService {

    ResponseEmployeeRecommendationDto save(EmployeeRecommendationDto recommendationDto);

    ResponseEmployeeRecommendationDto update(EmployeeRecommendationDto recommendationDto);

    List<ResponseEmployeeRecommendationDto> getAll(Long id);

   void delete(Long id);
}