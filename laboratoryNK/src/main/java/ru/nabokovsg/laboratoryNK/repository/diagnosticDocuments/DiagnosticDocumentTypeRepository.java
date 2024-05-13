package ru.nabokovsg.laboratoryNK.repository.diagnosticDocuments;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocuments.DiagnosticDocumentType;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocuments.TypeDocument;

public interface DiagnosticDocumentTypeRepository extends JpaRepository<DiagnosticDocumentType, Long> {

    DiagnosticDocumentType findByTitleAndSubtitleAndTypeDocument(String title
                                                              , String subtitle
                                                              , TypeDocument typeDocument);
}