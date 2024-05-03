package ru.nabokovsg.measurementNK.mapper.common;

import org.mapstruct.Mapper;
import ru.nabokovsg.measurementNK.dto.common.employeeRecommendation.EmployeeRecommendationDto;
import ru.nabokovsg.measurementNK.dto.common.employeeRecommendation.ResponseEmployeeRecommendationDto;
import ru.nabokovsg.measurementNK.model.common.EmployeeRecommendation;

@Mapper(componentModel = "spring")
public interface EmployeeRecommendationMapper {

    EmployeeRecommendation mapToEmployeeRecommendation(EmployeeRecommendationDto recommendationDto);

    ResponseEmployeeRecommendationDto mapToResponseEmployeeRecommendationDto(EmployeeRecommendation recommendation);
}