package ru.nabokovsg.laboratoryNK.dto.template.report.section;

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
@Schema(description = "Данные для добавления/изменения заголовка раздела документа")
public class SectionTemplateDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Порядковый номер")
    private Integer sequentialNumber;
    @Schema(description = "Название")
    private String sectionName;
    @Schema(description = "Индентификаторы подразделов")
    private List<Long> subsectionTemplatesId;
    @Schema(description = "Индентификаторы протоколов отчета")
    private List<Long> protocolReportTemplatesId;
}