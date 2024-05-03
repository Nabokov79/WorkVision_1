package ru.nabokovsg.measurementNK.mapper.norms;

import org.mapstruct.Mapper;
import ru.nabokovsg.measurementNK.dto.norms.geodesy.AcceptableDeviationsGeodesyDto;
import ru.nabokovsg.measurementNK.dto.norms.geodesy.ResponseAcceptableDeviationsGeodesyDto;
import ru.nabokovsg.measurementNK.model.norms.AcceptableDeviationsGeodesy;

@Mapper(componentModel = "spring")
public interface AcceptableDeviationsGeodesyMapper {

    AcceptableDeviationsGeodesy mapToPermissibleDeviationsGeodesy(AcceptableDeviationsGeodesyDto geodesyDto);

    ResponseAcceptableDeviationsGeodesyDto mapToResponseAcceptableDeviationsGeodesyDto(AcceptableDeviationsGeodesy geodesy);
}