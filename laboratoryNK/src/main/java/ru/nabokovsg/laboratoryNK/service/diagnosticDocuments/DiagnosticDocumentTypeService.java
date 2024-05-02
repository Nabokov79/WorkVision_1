package ru.nabokovsg.laboratoryNK.service.diagnosticDocuments;

import ru.nabokovsg.laboratoryNK.dto.diagnosticDocuments.DiagnosticDocumentTypeDto;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocuments.DiagnosticDocumentType;

import java.util.List;

public interface DiagnosticDocumentTypeService {

    DiagnosticDocumentTypeDto save(DiagnosticDocumentTypeDto documentTypeDto);

    DiagnosticDocumentTypeDto update(DiagnosticDocumentTypeDto documentTypeDto);

    List<DiagnosticDocumentTypeDto> getAll();

    void delete(Long id);

    DiagnosticDocumentType getById(Long diagnosticDocumentTypeId);
}