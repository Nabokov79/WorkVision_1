package ru.nabokovsg.diagnosedNK.service.norms;

import ru.nabokovsg.diagnosedNK.dto.norms.elementRepair.ElementRepairDto;
import ru.nabokovsg.diagnosedNK.dto.norms.elementRepair.ResponseElementRepairDto;
import ru.nabokovsg.diagnosedNK.dto.norms.elementRepair.ResponseShortElementRepairDto;

import java.util.List;

public interface ElementRepairService {

    ResponseElementRepairDto save(ElementRepairDto repairDto);

    ResponseElementRepairDto update(ElementRepairDto repairDto);

    ResponseElementRepairDto get(Long id);

    List<ResponseShortElementRepairDto> getAll();

    void delete(Long id);;
}