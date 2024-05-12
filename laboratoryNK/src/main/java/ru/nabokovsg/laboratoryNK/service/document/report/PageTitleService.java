package ru.nabokovsg.laboratoryNK.service.document.report;

import ru.nabokovsg.laboratoryNK.model.diagnosticDocuments.DiagnosticDocument;
import ru.nabokovsg.laboratoryNK.model.document.report.PageTitle;
import ru.nabokovsg.laboratoryNK.model.laboratoryEmployee.LaboratoryEmployee;
import ru.nabokovsg.laboratoryNK.model.template.report.PageTitleTemplate;

public interface PageTitleService {

    PageTitle save(DiagnosticDocument document
                 , String building
                 , LaboratoryEmployee chief
                 , PageTitleTemplate pageTitleTemplate);
}