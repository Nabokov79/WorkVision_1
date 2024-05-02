package ru.nabokovsg.laboratoryNK.dto.template.regulatoryDocumentationTemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные для добавления/изменения средства измерения")
public class RegulatoryDocumentationTemplateDto {

    @Schema(description = "Порядковый номер")
    private Integer sequentialNumber;
    @Schema(description = "Индентификатор шаблона нормативно-технической документации")
    private Long templateId;
}