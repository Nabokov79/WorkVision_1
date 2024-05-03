package ru.nabokovsg.measurementNK.service.norms;

import ru.nabokovsg.measurementNK.dto.norms.acceptableHardness.AcceptableHardnessDto;
import ru.nabokovsg.measurementNK.dto.norms.acceptableHardness.ResponseAcceptableHardnessDto;

import java.util.List;

public interface AcceptableHardnessService {

    ResponseAcceptableHardnessDto save(AcceptableHardnessDto hardnessDto);

    ResponseAcceptableHardnessDto update(AcceptableHardnessDto hardnessDto);

    List<ResponseAcceptableHardnessDto> getAll(Long id);

    void delete(Long id);
}