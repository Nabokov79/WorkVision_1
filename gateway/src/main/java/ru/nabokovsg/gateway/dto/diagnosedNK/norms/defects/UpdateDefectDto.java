package ru.nabokovsg.gateway.dto.diagnosedNK.norms.defects;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.gateway.dto.diagnosedNK.norms.measuredParameter.UpdateMeasuredParameterDto;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации о дефекте")
public class UpdateDefectDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id should not be null")
    @Positive(message = "id can only be positive")
    private Long id;
    @Schema(description = "Наименование дефекта")
    @NotBlank(message = "defectName should not be blank")
    private String defectName;
    @Schema(description = "Указание недопустимости дефекта")
    @NotNull(message = "notMeetRequirements should not be null")
    private Boolean notMeetRequirements;
    @Schema(description = "Требуемые вычисления параметров ремонта элемента")
    @NotBlank(message = "typeCalculation should not be blank")
    private String typeCalculation;
    @Schema(description = "Измеряемые параметры ремонта элемента")
    private List<@Valid UpdateMeasuredParameterDto> measuredParameters;
}