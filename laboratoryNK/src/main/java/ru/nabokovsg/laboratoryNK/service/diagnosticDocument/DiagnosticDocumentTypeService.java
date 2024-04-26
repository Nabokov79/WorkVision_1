package ru.nabokovsg.laboratoryNK.service.diagnosticDocument;

import ru.nabokovsg.laboratoryNK.dto.diagnosticDocument.DiagnosticDocumentTypeDto;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocument.DiagnosticDocumentType;

import java.util.List;

public interface DiagnosticDocumentTypeService {

    DiagnosticDocumentTypeDto save(DiagnosticDocumentTypeDto documentTypeDto);

    DiagnosticDocumentTypeDto update(DiagnosticDocumentTypeDto documentTypeDto);

    List<DiagnosticDocumentTypeDto> getAll();

    void delete(Long id);

    DiagnosticDocumentType getById(Long diagnosticDocumentTypeId);
}