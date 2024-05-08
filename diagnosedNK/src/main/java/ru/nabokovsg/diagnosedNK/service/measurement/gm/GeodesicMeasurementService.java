package ru.nabokovsg.diagnosedNK.service.measurement.gm;

import ru.nabokovsg.diagnosedNK.dto.measurement.geodesicMeasurement.GeodesicMeasurementDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.geodesicMeasurement.GeodeticMeasurementEquipmentDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.geodesicMeasurement.ResponseGeodesicMeasurementDto;

import java.util.List;

public interface GeodesicMeasurementService {

    List<ResponseGeodesicMeasurementDto> save(GeodeticMeasurementEquipmentDto measurementsDto);

    List<ResponseGeodesicMeasurementDto> update(List<GeodesicMeasurementDto> measurementsDto);

    List<ResponseGeodesicMeasurementDto> getAll(Long id);

    void delete(Long id);
}