package ru.nabokovsg.diagnosedNK.service.measurement.vms;

import ru.nabokovsg.diagnosedNK.dto.measurement.vms.DefectMeasurementDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.ResponseDefectMeasurementDto;

import java.util.List;

public interface DefectMeasurementService {

    ResponseDefectMeasurementDto save(DefectMeasurementDto defectMeasurementDto);

    List<ResponseDefectMeasurementDto> getAll(Long id);

    void delete(Long id);
}