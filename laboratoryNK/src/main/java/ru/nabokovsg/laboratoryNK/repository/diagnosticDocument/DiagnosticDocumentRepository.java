package ru.nabokovsg.laboratoryNK.repository.diagnosticDocument;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocument.DiagnosticDocument;

public interface DiagnosticDocumentRepository extends JpaRepository<DiagnosticDocument, Long> {
}