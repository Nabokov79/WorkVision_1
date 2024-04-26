package ru.nabokovsg.laboratoryNK.service.diagnosticDocument;

import ru.nabokovsg.laboratoryNK.dto.diagnosticDocument.DiagnosticDocumentDto;
import ru.nabokovsg.laboratoryNK.dto.surveyJournal.ResponseSurveyJournalDto;
import ru.nabokovsg.laboratoryNK.dto.surveyJournal.SurveyJournalDto;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocument.DiagnosticDocument;

import java.time.LocalDate;
import java.util.List;

public interface DiagnosticDocumentService {

    void save(SurveyJournalDto journalDto, ResponseSurveyJournalDto journal);

    void update(SurveyJournalDto journalDto, ResponseSurveyJournalDto journal);

    List<DiagnosticDocumentDto> getAll(LocalDate startPeriod, LocalDate endPeriod, boolean week, boolean month);

   void validateByStatus(Long taskJournalId);
    DiagnosticDocument getById(Long id);
}