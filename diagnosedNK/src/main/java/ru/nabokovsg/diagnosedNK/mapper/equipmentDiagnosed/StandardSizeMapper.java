package ru.nabokovsg.diagnosedNK.mapper.equipmentDiagnosed;

import org.mapstruct.Mapper;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.standardSize.StandardSizeDto;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.StandardSize;

@Mapper(componentModel = "spring")
public interface StandardSizeMapper {

    StandardSize mapToStandardSize(StandardSizeDto standardSizeDto);
}