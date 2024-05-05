package ru.nabokovsg.diagnosedNK.dto.measurement.сontrolPoint;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Рассчитанные данные высоты по измерениям контрольной точки(геодезия)")
public class ControlPointDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Номер репера")
    private Integer placeNumber;
    @Schema(description = "Рассчитанныя высота измерения")
    private Integer calculatedHeight;
    @Schema(description = "Отклонение от минимальной рассчитанной высоты измерения")
    private Integer deviation;
}
