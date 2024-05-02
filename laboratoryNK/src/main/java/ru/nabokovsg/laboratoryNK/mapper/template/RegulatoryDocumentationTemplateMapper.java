package ru.nabokovsg.laboratoryNK.mapper.template;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.dto.template.regulatoryDocumentationTemplate.ResponseRegulatoryDocumentationTemplateDto;
import ru.nabokovsg.laboratoryNK.model.common.Documentation;
import ru.nabokovsg.laboratoryNK.model.template.RegulatoryDocumentationTemplate;
import ru.nabokovsg.laboratoryNK.model.template.SubsectionTemplate;

@Mapper(componentModel = "spring")
public interface RegulatoryDocumentationTemplateMapper {

    @Mapping(source = "documentation.id", target = "documentationId")
    @Mapping(source = "documentName", target = "documentName")
    @Mapping(target = "sequentialNumber", ignore = true)
    @Mapping(target = "subsectionTemplate", ignore = true)
    @Mapping(target = "id", ignore = true)
    RegulatoryDocumentationTemplate mapToRegulatoryDocumentationTemplate(Documentation documentation
                                                                       , String documentName);

    @Mapping(source = "documentation.id", target = "documentationId")
    @Mapping(source = "documentName", target = "documentName")
    @Mapping(source = "template.sequentialNumber", target = "sequentialNumber")
    @Mapping(source = "template.subsectionTemplate", target = "subsectionTemplate")
    @Mapping(source = "template.id", target = "id")
    RegulatoryDocumentationTemplate mapToUpdateRegulatoryDocumentationTemplate(RegulatoryDocumentationTemplate template
                                                                             , Documentation documentation
                                                                             , String documentName);

    ResponseRegulatoryDocumentationTemplateDto mapToResponseRegulatoryDocumentationTemplateDto(
                                                                              RegulatoryDocumentationTemplate template);

    @Mapping(source = "template.documentationId", target = "documentationId")
    @Mapping(source = "template.documentName", target = "documentName")
    @Mapping(source = "sequentialNumber", target = "sequentialNumber")
    @Mapping(source = "subsectionTemplate", target = "subsectionTemplate")
    @Mapping(source = "template.id", target = "id")
    RegulatoryDocumentationTemplate mapToWithSubsectionTemplate(RegulatoryDocumentationTemplate template
                                                              , SubsectionTemplate subsectionTemplate
                                                              , Integer sequentialNumber);
}