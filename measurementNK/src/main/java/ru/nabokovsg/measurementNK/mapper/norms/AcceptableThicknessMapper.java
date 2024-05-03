package ru.nabokovsg.measurementNK.mapper.norms;

import org.mapstruct.Mapper;
import ru.nabokovsg.measurementNK.dto.norms.acceptableThickness.AcceptableThicknessDto;
import ru.nabokovsg.measurementNK.dto.norms.acceptableThickness.ResponseAcceptableThicknessDto;
import ru.nabokovsg.measurementNK.model.norms.AcceptableThickness;

@Mapper(componentModel = "spring")
public interface AcceptableThicknessMapper {

    AcceptableThickness mapToAcceptableThickness(AcceptableThicknessDto thicknessDto);

    ResponseAcceptableThicknessDto mapToResponseAcceptableThicknessDto(AcceptableThickness thickness);
}