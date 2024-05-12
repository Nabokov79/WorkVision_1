package ru.nabokovsg.laboratoryNK.repository.document;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.document.RegulatoryDocumentation;

public interface RegulatoryDocumentationRepository extends JpaRepository<RegulatoryDocumentation, Long> {
}