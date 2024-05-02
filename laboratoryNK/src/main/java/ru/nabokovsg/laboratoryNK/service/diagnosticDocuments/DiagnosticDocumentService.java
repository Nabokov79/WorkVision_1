package ru.nabokovsg.laboratoryNK.service.diagnosticDocuments;

import ru.nabokovsg.laboratoryNK.dto.diagnosticDocuments.DiagnosticDocumentDto;
import ru.nabokovsg.laboratoryNK.dto.common.surveyJournal.ResponseSurveyJournalDto;
import ru.nabokovsg.laboratoryNK.dto.common.surveyJournal.SurveyJournalDto;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocuments.DiagnosticDocument;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocuments.DocumentStatus;

import java.time.LocalDate;
import java.util.List;

public interface DiagnosticDocumentService {

    void save(SurveyJournalDto journalDto, ResponseSurveyJournalDto journal);

    void update(SurveyJournalDto journalDto, ResponseSurveyJournalDto journal);

    List<DiagnosticDocumentDto> getAll(LocalDate startPeriod, LocalDate endPeriod, boolean week, boolean month);

   void validateByStatus(Long taskJournalId);

    DiagnosticDocument getById(Long id);

    void updateStatus(DiagnosticDocument document, DocumentStatus status);
}