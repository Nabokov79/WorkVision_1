package ru.nabokovsg.laboratoryNK.service.common;

import ru.nabokovsg.laboratoryNK.dto.common.surveyJournal.ResponseSurveyJournalDto;
import ru.nabokovsg.laboratoryNK.dto.common.surveyJournal.SurveyJournalDto;

import java.time.LocalDate;
import java.util.List;

public interface SurveyJournalService {

    ResponseSurveyJournalDto save(SurveyJournalDto journalDto);

    ResponseSurveyJournalDto update(SurveyJournalDto journalDto);

    List<ResponseSurveyJournalDto> getAll(LocalDate startPeriod, LocalDate endPeriod);

    void delete(Long id);
}