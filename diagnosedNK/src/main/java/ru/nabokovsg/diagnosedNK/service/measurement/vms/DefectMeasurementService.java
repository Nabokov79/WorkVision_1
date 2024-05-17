package ru.nabokovsg.diagnosedNK.service.measurement.vms;

import ru.nabokovsg.diagnosedNK.dto.measurement.vms.defectMeasurement.DefectMeasurementDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.defectMeasurement.ResponseDefectMeasurementDto;
import ru.nabokovsg.diagnosedNK.model.measurement.utm.UltrasonicThicknessMeasurement;

import java.util.List;

public interface DefectMeasurementService {

    ResponseDefectMeasurementDto save(DefectMeasurementDto defectMeasurementDto);

    ResponseDefectMeasurementDto update(DefectMeasurementDto defectMeasurementDto);

    List<ResponseDefectMeasurementDto> getAll(Long id);

    void delete(Long id);

    Double getMaxCorrosionValueByPredicate(UltrasonicThicknessMeasurement measurement);
}