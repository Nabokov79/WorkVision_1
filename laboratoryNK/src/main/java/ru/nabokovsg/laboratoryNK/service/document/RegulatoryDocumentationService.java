package ru.nabokovsg.laboratoryNK.service.document;

import ru.nabokovsg.laboratoryNK.model.document.Subsection;
import ru.nabokovsg.laboratoryNK.model.template.RegulatoryDocumentationTemplate;

import java.util.List;

public interface RegulatoryDocumentationService {

    void save(Subsection subsection, List<RegulatoryDocumentationTemplate> documentationTemplate);
}