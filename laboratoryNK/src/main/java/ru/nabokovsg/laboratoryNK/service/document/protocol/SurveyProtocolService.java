package ru.nabokovsg.laboratoryNK.service.document.protocol;

import ru.nabokovsg.laboratoryNK.model.common.SurveyJournal;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocuments.DiagnosticDocument;

public interface SurveyProtocolService {

    void save(SurveyJournal surveyJournal, DiagnosticDocument document);
}