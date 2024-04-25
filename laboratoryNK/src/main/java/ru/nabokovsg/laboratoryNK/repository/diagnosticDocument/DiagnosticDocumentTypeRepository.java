package ru.nabokovsg.laboratoryNK.repository.diagnosticDocument;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocument.DiagnosticDocumentType;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocument.TypeDocument;

public interface DiagnosticDocumentTypeRepository extends JpaRepository<DiagnosticDocumentType, Long> {

    DiagnosticDocumentType findByTitleAndHeadingAndTypeDocument(String title
                                                              , String heading
                                                              , TypeDocument typeDocument);
}