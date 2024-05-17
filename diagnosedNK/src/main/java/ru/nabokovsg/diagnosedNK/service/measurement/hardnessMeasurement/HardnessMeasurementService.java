package ru.nabokovsg.diagnosedNK.service.measurement.hardnessMeasurement;

import ru.nabokovsg.diagnosedNK.dto.measurement.hardnessMeasurement.HardnessMeasurementDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.hardnessMeasurement.ResponseHardnessMeasurementDto;

import java.util.List;

public interface HardnessMeasurementService {

    List<ResponseHardnessMeasurementDto> save(HardnessMeasurementDto measurementDto);

    List<ResponseHardnessMeasurementDto> update(HardnessMeasurementDto measurementDto);

    List<ResponseHardnessMeasurementDto> getAll(Long id);

    void delete(Long id);
}