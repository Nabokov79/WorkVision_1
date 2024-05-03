package ru.nabokovsg.measurementNK.service.norms;

import ru.nabokovsg.measurementNK.dto.norms.geodesy.AcceptableDeviationsGeodesyDto;
import ru.nabokovsg.measurementNK.dto.norms.geodesy.ResponseAcceptableDeviationsGeodesyDto;

import java.util.List;

public interface AcceptableDeviationsGeodesyService {

    ResponseAcceptableDeviationsGeodesyDto save(AcceptableDeviationsGeodesyDto geodesyDto);

    ResponseAcceptableDeviationsGeodesyDto update(AcceptableDeviationsGeodesyDto geodesyDto);

    List<ResponseAcceptableDeviationsGeodesyDto> getAll(Long id);

    void delete(Long id);
}