package ru.nabokovsg.diagnosedNK.dto.measurement.сontrolPoint;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.diagnosedNK.model.measurement.gm.GeodesicPointType;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Рассчитанные значения для соседних и диаметрально противоположных точек измерения")
public class PointDifferenceDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Тип рассчитанных точек")
    private GeodesicPointType geodesicPointType;
    @Schema(description = "Первое место измерения(номер контрольной точки)")
    private Integer firstPlaceNumber;
    @Schema(description = "Второе место измерения(номер контрольной точки)")
    private Integer secondPlaceNumber;
    @Schema(description = "Разность отклонений контрольных точек")
    private Integer difference;
    @Schema(description = "Допустимость значение отклонения")
    private Integer acceptableDifference;
}