package ru.nabokovsg.diagnosedNK.dto.measurement.сontrolPoint;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные расчетов геодезических измерений")
public class ResultControlPoint {

    private List<ControlPointDto> controlPoints;
    private List<PointDifferenceDto> pointDifferences;
}