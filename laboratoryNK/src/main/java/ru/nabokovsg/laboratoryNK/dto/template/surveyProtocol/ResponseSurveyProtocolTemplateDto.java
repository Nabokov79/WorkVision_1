package ru.nabokovsg.laboratoryNK.dto.template.surveyProtocol;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.laboratoryNK.dto.template.appendices.AppendicesTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.conclusion.ResponseConclusionTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.documentHeader.ResponseDocumentHeaderTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.subsectionTemplate.ResponseSubsectionTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.table.ResponseTableTemplateDto;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные шаблона протокола/заключения по обследованию")
public class ResponseSurveyProtocolTemplateDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Заголовок")
    private Set<ResponseDocumentHeaderTemplateDto> leftHeaderTemplate;
    @Schema(description = "Название документа")
    private String title;
    @Schema(description = "Заголовок документа")
    private String subtitle;
    @Schema(description = "Шаблоны подразделов")
    private List<ResponseSubsectionTemplateDto> subsectionTemplates;
    @Schema(description = "Шаблоны таблиц")
    private List<ResponseTableTemplateDto> tableTemplates;
    @Schema(description = "Заключение по результатм")
    private ResponseConclusionTemplateDto conclusionTemplate;
    @Schema(description = "Приложения")
    private List<AppendicesTemplateDto> appendices;
}