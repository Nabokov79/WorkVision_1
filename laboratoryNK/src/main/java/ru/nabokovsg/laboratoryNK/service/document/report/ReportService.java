package ru.nabokovsg.laboratoryNK.service.document.report;

import ru.nabokovsg.laboratoryNK.model.common.SurveyJournal;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocuments.DiagnosticDocument;

public interface ReportService {

    void save(SurveyJournal surveyJournal, DiagnosticDocument document);
}