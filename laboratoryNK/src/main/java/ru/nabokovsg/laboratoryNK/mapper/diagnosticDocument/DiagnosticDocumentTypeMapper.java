package ru.nabokovsg.laboratoryNK.mapper.diagnosticDocument;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.dto.diagnosticDocuments.DiagnosticDocumentTypeDto;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocuments.DiagnosticDocumentType;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocuments.TypeDocument;

@Mapper(componentModel = "spring")
public interface DiagnosticDocumentTypeMapper {

    @Mapping(source = "typeDocument", target = "typeDocument")
    @Mapping(source = "documentTypeDto.id", target = "id")
    DiagnosticDocumentType mapToDiagnosticDocument(DiagnosticDocumentTypeDto documentTypeDto, TypeDocument typeDocument);

    DiagnosticDocumentTypeDto mapToDiagnosticDocumentTypeDto(DiagnosticDocumentType documentType);
}