package ru.nabokovsg.measurementNK.service.norms;

import ru.nabokovsg.measurementNK.dto.norms.acceptableThickness.AcceptableThicknessDto;
import ru.nabokovsg.measurementNK.dto.norms.acceptableThickness.ResponseAcceptableThicknessDto;
import java.util.List;

public interface AcceptableThicknessService {

    ResponseAcceptableThicknessDto save(AcceptableThicknessDto thicknessDto);

    ResponseAcceptableThicknessDto update(AcceptableThicknessDto thicknessDto);

    List<ResponseAcceptableThicknessDto> getAll(Long id);

    void delete(Long id);
}