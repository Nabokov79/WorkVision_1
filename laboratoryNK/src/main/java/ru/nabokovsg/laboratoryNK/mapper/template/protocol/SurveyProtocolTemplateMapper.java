package ru.nabokovsg.laboratoryNK.mapper.template.protocol;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.model.template.ConclusionTemplate;
import ru.nabokovsg.laboratoryNK.dto.template.surveyProtocol.SurveyProtocolTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.surveyProtocol.ResponseSurveyProtocolTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.surveyProtocol.ShortResponseSurveyProtocolTemplateDto;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocuments.DiagnosticDocumentType;
import ru.nabokovsg.laboratoryNK.model.template.DocumentHeaderTemplate;
import ru.nabokovsg.laboratoryNK.model.template.protocol.SurveyProtocolTemplate;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface SurveyProtocolTemplateMapper {

    @Mapping(source = "protocolDto.documentTypeId", target = "documentTypeId")
    @Mapping(source = "protocolDto.equipmentTypeId", target = "equipmentTypeId")
    @Mapping(source = "documentHeaders", target = "leftHeaderTemplates")
    @Mapping(source = "documentType.title", target = "title")
    @Mapping(source = "documentType.subtitle", target = "subtitle")
    @Mapping(source = "conclusionTemplate", target = "conclusionTemplate")
    @Mapping(source = "protocolDto.id", target = "id")
    SurveyProtocolTemplate mapToProtocolTemplate(SurveyProtocolTemplateDto protocolDto
                                         , DiagnosticDocumentType documentType
                                         , Set<DocumentHeaderTemplate> documentHeaders
                                         , ConclusionTemplate conclusionTemplate);

    ShortResponseSurveyProtocolTemplateDto mapToShortResponseProtocolTemplateDto(SurveyProtocolTemplate protocolTemplate);

    ResponseSurveyProtocolTemplateDto mapToResponseProtocolTemplateDto(SurveyProtocolTemplate protocolTemplate);
}