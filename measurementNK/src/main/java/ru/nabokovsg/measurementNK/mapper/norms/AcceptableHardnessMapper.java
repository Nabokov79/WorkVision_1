package ru.nabokovsg.measurementNK.mapper.norms;

import org.mapstruct.Mapper;
import ru.nabokovsg.measurementNK.dto.norms.acceptableHardness.AcceptableHardnessDto;
import ru.nabokovsg.measurementNK.dto.norms.acceptableHardness.ResponseAcceptableHardnessDto;
import ru.nabokovsg.measurementNK.model.norms.AcceptableHardness;

@Mapper(componentModel = "spring")
public interface AcceptableHardnessMapper {

    AcceptableHardness mapToAcceptableHardness(AcceptableHardnessDto hardnessDto);

    ResponseAcceptableHardnessDto mapToResponseAcceptableHardnessDto(AcceptableHardness hardness);
}