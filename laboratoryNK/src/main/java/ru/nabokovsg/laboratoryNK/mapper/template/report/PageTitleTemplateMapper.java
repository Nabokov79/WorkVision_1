package ru.nabokovsg.laboratoryNK.mapper.template.report;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.dto.template.report.pageTitle.PageTitleTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.report.pageTitle.ResponsePageTitleTemplateDto;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocuments.DiagnosticDocumentType;
import ru.nabokovsg.laboratoryNK.model.template.DocumentHeaderTemplate;
import ru.nabokovsg.laboratoryNK.model.template.report.PageTitleTemplate;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface PageTitleTemplateMapper {

    @Mapping(source = "documentHeaders", target = "documentHeaders")
    @Mapping(source = "documentType.title", target = "title")
    @Mapping(source = "documentType.subtitle", target = "subtitle")
    @Mapping(source = "pageTitleDto.equipmentText", target = "equipmentText")
    @Mapping(source = "pageTitleDto.city", target = "city")
    @Mapping(source = "pageTitleDto.id", target = "id")
    PageTitleTemplate mapToPageTitleTemplate(PageTitleTemplateDto pageTitleDto
                                           , DiagnosticDocumentType documentType
                                           , Set<DocumentHeaderTemplate> documentHeaders);

    ResponsePageTitleTemplateDto mapToResponsePageTitleTemplateDto(PageTitleTemplate pageTitle);
}