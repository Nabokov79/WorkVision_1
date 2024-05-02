package ru.nabokovsg.laboratoryNK.mapper.template.report;

import org.mapstruct.Mapper;
import ru.nabokovsg.laboratoryNK.dto.template.report.ResponseReportTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.report.ShortResponseReportTemplateDto;
import ru.nabokovsg.laboratoryNK.model.template.report.PageTitleTemplate;
import ru.nabokovsg.laboratoryNK.model.template.report.ReportTemplate;

@Mapper(componentModel = "spring")
public interface ReportTemplateMapper {

    ReportTemplate mapToReportTemplate(Long documentTypeId, Long equipmentTypeId, PageTitleTemplate template);

    ResponseReportTemplateDto mapToResponseReportTemplateDto(ReportTemplate reportTemplate);

    ShortResponseReportTemplateDto mapToShortResponseReportTemplateDto(PageTitleTemplate pageTitleTemplate);
}