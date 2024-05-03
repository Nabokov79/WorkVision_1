package ru.nabokovsg.measurementNK.service.norms;

import ru.nabokovsg.measurementNK.dto.norms.elementRepair.ElementRepairDto;
import ru.nabokovsg.measurementNK.dto.norms.elementRepair.ResponseElementRepairDto;
import ru.nabokovsg.measurementNK.dto.norms.elementRepair.ResponseShortElementRepairDto;

import java.util.List;

public interface ElementRepairService {

    ResponseElementRepairDto save(ElementRepairDto repairDto);

    ResponseElementRepairDto update(ElementRepairDto repairDto);

    ResponseElementRepairDto get(Long id);

    List<ResponseShortElementRepairDto> getAll();

    void delete(Long id);;
}