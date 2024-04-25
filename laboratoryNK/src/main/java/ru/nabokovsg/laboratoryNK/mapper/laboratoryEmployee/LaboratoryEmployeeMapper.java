package ru.nabokovsg.laboratoryNK.mapper.laboratoryEmployee;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.dto.laboratoryEmployee.employees.ResponseLaboratoryEmployeeDto;
import ru.nabokovsg.laboratoryNK.dto.laboratoryEmployee.employees.ShortResponseLaboratoryEmployeeDto;
import ru.nabokovsg.laboratoryNK.model.laboratoryEmployee.LaboratoryEmployee;

@Mapper(componentModel = "spring")
public interface LaboratoryEmployeeMapper {

    @Mapping(source = "employeeId", target = "employeeId")
    @Mapping(source = "post", target = "post")
    @Mapping(source = "initials", target = "initials")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "certificates", ignore = true)
    LaboratoryEmployee mapToLaboratoryEmployee(Long employeeId, String post, String initials);

    ShortResponseLaboratoryEmployeeDto mapToShortLaboratoryEmployeeDto(LaboratoryEmployee employee);

    ResponseLaboratoryEmployeeDto mapToFullLaboratoryEmployeeDto(LaboratoryEmployee employee);
}