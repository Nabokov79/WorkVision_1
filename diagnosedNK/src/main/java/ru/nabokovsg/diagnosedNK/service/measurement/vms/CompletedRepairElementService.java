package ru.nabokovsg.diagnosedNK.service.measurement.vms;

import ru.nabokovsg.diagnosedNK.dto.measurement.vms.completedRepairElement.CompletedRepairElementDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.completedRepairElement.ResponseCompletedRepairElementDto;

import java.util.List;

public interface CompletedRepairElementService {

    ResponseCompletedRepairElementDto save(CompletedRepairElementDto repairDto);

    ResponseCompletedRepairElementDto update(CompletedRepairElementDto repairDto);

   List<ResponseCompletedRepairElementDto> getAll(Long id);

    void delete(Long id);
}