package ru.nabokovsg.diagnosedNK.service.measurement.utm;

import ru.nabokovsg.diagnosedNK.dto.measurement.utm.ResponseUltrasonicThicknessMeasurementDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.utm.UltrasonicThicknessMeasurementDto;

import java.util.List;

public interface UltrasonicThicknessMeasurementService {

    ResponseUltrasonicThicknessMeasurementDto save(UltrasonicThicknessMeasurementDto measurementDto);

   ResponseUltrasonicThicknessMeasurementDto update(UltrasonicThicknessMeasurementDto measurementDto);

    List<ResponseUltrasonicThicknessMeasurementDto> getAll(Long id);

    void delete(Long id);
}