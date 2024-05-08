package ru.nabokovsg.diagnosedNK.dto.measurement.vms.parameterMeasurement;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Измеренное значение параметра дефекта")
public class ParameterMeasurementDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Индентификатор параметра")
    private Long parameterId;
    @Schema(description = "Минимальное значение параметра")
    private Double minValue;
    @Schema(description = "Максимальное значение параметра")
    private Double maxValue;
}