package ru.nabokovsg.gateway.dto.diagnosedNK.common.equipmentInspection;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные для добавления/изменения информации об обследовании оборудования")
public class NewEquipmentInspectionDto {

    @Schema(description = "Дата проведения обследования")
    @NotBlank(message = "date should not be blank")
    private String date;
    @Schema(description = "Описание выполненного обследования")
    @NotBlank(message = "inspection should not be blank")
    private String inspection;
    @Schema(description = "Номер документа, выданного по результатам обследования")
    @NotBlank(message = "organization should not be blank")
    private String documentNumber;
    @Schema(description = "Организация, выполнившая обследование")
    @NotBlank(message = " organization should not be blank")
    private String organization;
    @Schema(description = "Индентификатор диагностируемого оборудования")
    @NotNull(message = "equipmentDiagnosed id should not be null")
    @Positive(message = "equipmentDiagnosed id can only be positive")
    private Long equipmentDiagnosedId;
}