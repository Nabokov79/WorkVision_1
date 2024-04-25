package ru.nabokovsg.laboratoryNK.service.diagnosticDocument;

import ru.nabokovsg.laboratoryNK.dto.diagnosticDocument.DiagnosticDocumentTypeDto;

import java.util.List;

public interface DocumentTypeService {

    DiagnosticDocumentTypeDto save(DiagnosticDocumentTypeDto documentTypeDto);

    DiagnosticDocumentTypeDto update(DiagnosticDocumentTypeDto documentTypeDto);

    List<DiagnosticDocumentTypeDto> getAll();

    void delete(Long id);
}