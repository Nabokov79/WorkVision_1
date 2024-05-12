package ru.nabokovsg.laboratoryNK.service.document;

import ru.nabokovsg.laboratoryNK.model.document.report.PageTitle;
import ru.nabokovsg.laboratoryNK.model.template.DocumentHeaderTemplate;

import java.util.Set;

public interface DocumentHeaderService {

    void saveForPageTitle(PageTitle pageTitle, Set<DocumentHeaderTemplate> documentHeaders);
}