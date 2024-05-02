package ru.nabokovsg.laboratoryNK.dto.template.protocol;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные для добавления/изменения протокола/заключения по обследованию")
public class ProtocolTemplateDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Индентификатор типа оборудования")
    private Long equipmentTypeId;
    @Schema(description = "Индентификатор типа отчетного документа")
    private Long documentTypeId;
    @Schema(description = "Индентификатор подразделов протокола")
    private List<Long> subsectionTemplatesId;
    @Schema(description = "Индентификатор таблиц протокола")
    private List<Long> tableTemplatesId;
}