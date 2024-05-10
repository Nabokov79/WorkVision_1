package ru.nabokovsg.diagnosedNK.service.measurement.vms;

import ru.nabokovsg.diagnosedNK.dto.measurement.vms.visualInspection.ResponseVisualInspectionDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.visualInspection.VisualInspectionDto;

import java.util.List;

public interface VisualInspectionService {

    ResponseVisualInspectionDto save(VisualInspectionDto inspectionDto);

    ResponseVisualInspectionDto update(VisualInspectionDto inspectionDto);

    List<ResponseVisualInspectionDto> getAll(Long id);

    void delete(Long id);
}