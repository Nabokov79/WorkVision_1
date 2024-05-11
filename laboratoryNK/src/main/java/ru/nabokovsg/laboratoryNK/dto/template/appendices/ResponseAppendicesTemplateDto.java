package ru.nabokovsg.laboratoryNK.dto.template.appendices;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные приложения к документу")
public class ResponseAppendicesTemplateDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "ПНаименование списка приложений")
    private String nameOfList;
    @Schema(description = "Порядковый номер")
    private Integer sequentialNumber;
    @Schema(description = "Наименование")
    private String appendicesName;
}