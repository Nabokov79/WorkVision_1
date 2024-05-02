package ru.nabokovsg.laboratoryNK.repository.template;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.template.RegulatoryDocumentationTemplate;

public interface RegulatoryDocumentationTemplateRepository extends JpaRepository<RegulatoryDocumentationTemplate, Long> {

    RegulatoryDocumentationTemplate findByDocumentationId(Long documentationId);
}