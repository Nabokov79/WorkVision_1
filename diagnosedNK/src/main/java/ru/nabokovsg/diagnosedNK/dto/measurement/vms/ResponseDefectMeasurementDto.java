package ru.nabokovsg.diagnosedNK.dto.measurement.vms;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.parameterMeasurement.CalculationParameterMeasurementDto;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные измеренного дефекта")
public class ResponseDefectMeasurementDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Индентификатор элемента")
    private Long elementId;
    @Schema(description = "Индентификатор подэлемента")
    private Long partElementId;
    @Schema(description = "Наименование дефекта")
    private String defectName;
    @Schema(description = "Указание недопустимого дефекта")
    private Boolean notMeetRequirements;
    @Schema(description = "Рассчитанные параметры дефекта")
    private Set<CalculationParameterMeasurementDto> parameterMeasurements;
}