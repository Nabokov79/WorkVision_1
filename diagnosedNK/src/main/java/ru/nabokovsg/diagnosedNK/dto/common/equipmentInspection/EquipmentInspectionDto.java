package ru.nabokovsg.diagnosedNK.dto.common.equipmentInspection;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные для добавления/изменения информации об обследовании оборудования")
public class EquipmentInspectionDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Индентификатор записи журнала задач")
    private Long taskJournalId;
    @Schema(description = "Дата проведения обследования")
    private String date;
    @Schema(description = "Описание выполненного обследования")
    private String inspection;
    @Schema(description = "Номер документа, выданного по результатам обследования")
    private String documentNumber;
    @Schema(description = "Организация, выполнившая обследование")
    private String organization;
    @Schema(description = "Индентификатор диагностируемого оборудования")
    private Long equipmentDiagnosedId;
}