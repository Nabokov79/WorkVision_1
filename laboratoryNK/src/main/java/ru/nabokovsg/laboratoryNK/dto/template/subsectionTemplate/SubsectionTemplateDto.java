package ru.nabokovsg.laboratoryNK.dto.template.subsectionTemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokovsg.laboratoryNK.dto.template.measuringToolTemplate.MeasuringToolTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.regulatoryDocumentationTemplate.RegulatoryDocumentationTemplateDto;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные для добавления/изменения информации в подразделе")
public class SubsectionTemplateDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Порядковый номер подраздела")
    private Double sequentialNumber;
    @Schema(description = "Наименование подраздела")
    private String subsectionName;
    @Schema(description = "Текст пользователя")
    private String userText;
    @Schema(description = "Тип данных подраздела")
    private DivisionParamDto divisionParam;
    @Schema(description = "Индентификатор таблицы")
    private Long tableId;
    @Schema(description = "Данные нормативно-технической документации")
    private List<RegulatoryDocumentationTemplateDto> documentations;
    @Schema(description = "Данные средств контроля и измерений")
    private List<MeasuringToolTemplateDto> measuringTools;
}