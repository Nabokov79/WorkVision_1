package ru.nabokovsg.diagnosedNK.mapper.common;

import org.mapstruct.Mapper;
import ru.nabokovsg.diagnosedNK.dto.common.employeeRecommendation.EmployeeRecommendationDto;
import ru.nabokovsg.diagnosedNK.dto.common.employeeRecommendation.ResponseEmployeeRecommendationDto;
import ru.nabokovsg.diagnosedNK.model.common.EmployeeRecommendation;

@Mapper(componentModel = "spring")
public interface EmployeeRecommendationMapper {

    EmployeeRecommendation mapToEmployeeRecommendation(EmployeeRecommendationDto recommendationDto);

    ResponseEmployeeRecommendationDto mapToResponseEmployeeRecommendationDto(EmployeeRecommendation recommendation);
}