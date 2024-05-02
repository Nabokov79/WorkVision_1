package ru.nabokovsg.laboratoryNK.mapper.template.protocol;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.controller.template.ConclusionTemplate;
import ru.nabokovsg.laboratoryNK.dto.template.protocol.ProtocolTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.protocol.ResponseProtocolTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.protocol.ShortResponseProtocolTemplateDto;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocuments.DiagnosticDocumentType;
import ru.nabokovsg.laboratoryNK.model.template.DocumentHeader;
import ru.nabokovsg.laboratoryNK.model.template.protocol.ProtocolTemplate;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProtocolTemplateMapper {

    @Mapping(source = "protocolDto.documentTypeId", target = "documentTypeId")
    @Mapping(source = "protocolDto.equipmentTypeId", target = "equipmentTypeId")
    @Mapping(source = "documentHeaders", target = "leftHeaderTemplates")
    @Mapping(source = "documentType.title", target = "title")
    @Mapping(source = "documentType.subtitle", target = "subtitle")
    @Mapping(source = "conclusionTemplate", target = "conclusionTemplate")
    @Mapping(source = "protocolDto.id", target = "id")
    ProtocolTemplate mapToProtocolTemplate(ProtocolTemplateDto protocolDto
                                         , DiagnosticDocumentType documentType
                                         , Set<DocumentHeader> documentHeaders
                                         , ConclusionTemplate conclusionTemplate);

    ShortResponseProtocolTemplateDto mapToShortResponseProtocolTemplateDto(ProtocolTemplate protocolTemplate);

    ResponseProtocolTemplateDto mapToResponseProtocolTemplateDto(ProtocolTemplate protocolTemplate);
}