package ru.nabokovsg.laboratoryNK.mapper.template.protocol;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.dto.template.protocolControl.ProtocolControlTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.protocolControl.ResponseProtocolControlTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.protocolControl.ShortResponseProtocolControlTemplateDto;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocuments.DiagnosticDocumentType;
import ru.nabokovsg.laboratoryNK.model.template.DocumentHeaderTemplate;
import ru.nabokovsg.laboratoryNK.model.template.protocol.ProtocolControlTemplate;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProtocolControlTemplateMapper {

    @Mapping(source = "protocolDto.documentTypeId", target = "documentTypeId")
    @Mapping(source = "documentHeaders", target = "leftHeaderTemplates")
    @Mapping(source = "documentType.title", target = "title")
    @Mapping(source = "documentType.subtitle", target = "subtitle")
    @Mapping(source = "protocolDto.id", target = "id")
    ProtocolControlTemplate mapToProtocolTemplate(ProtocolControlTemplateDto protocolDto
                                                , DiagnosticDocumentType documentType
                                                , Set<DocumentHeaderTemplate> documentHeaders);

    ShortResponseProtocolControlTemplateDto mapToShortResponseProtocolTemplateDto(ProtocolControlTemplate protocolTemplate);

    ResponseProtocolControlTemplateDto mapToResponseProtocolTemplateDto(ProtocolControlTemplate protocolTemplate);
}