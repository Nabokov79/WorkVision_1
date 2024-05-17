package ru.nabokovsg.gateway.dto.diagnosedNK.norms.measuredParameter;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации о параметре измерения")
public class UpdateMeasuredParameterDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id should not be null")
    @Positive(message = "id can only be positive")
    private Long id;
    @Schema(description = "Наименование параметра")
    @NotBlank(message = "measuredParameter should not be blank")
    private String measuredParameter;
    @Schema(description = "Единица измерения параметра")
    @NotBlank(message = "unitMeasurement should not be blank")
    private String unitMeasurement;
    @Schema(description = "Требуемые вычисления параметров дефекта")
    @NotBlank(message = "typeCalculation should not be blank")
    private String typeCalculation;
}