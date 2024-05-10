package ru.nabokovsg.diagnosedNK.service.norms;

import ru.nabokovsg.diagnosedNK.dto.norms.acceptableThickness.AcceptableThicknessDto;
import ru.nabokovsg.diagnosedNK.dto.norms.acceptableThickness.ResponseAcceptableThicknessDto;
import ru.nabokovsg.diagnosedNK.model.measurement.utm.UltrasonicThicknessMeasurement;
import ru.nabokovsg.diagnosedNK.model.norms.AcceptableThickness;

import java.util.List;

public interface AcceptableThicknessService {

    ResponseAcceptableThicknessDto save(AcceptableThicknessDto thicknessDto);

    ResponseAcceptableThicknessDto update(AcceptableThicknessDto thicknessDto);

    List<ResponseAcceptableThicknessDto> getAll(Long id);

    void delete(Long id);

    AcceptableThickness getAcceptableThickness(UltrasonicThicknessMeasurement measurement);
}