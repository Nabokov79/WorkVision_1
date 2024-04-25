package ru.nabokovsg.laboratoryNK.service.diagnosticDocument;

import ru.nabokovsg.laboratoryNK.dto.tasksJournal.ResponseTasksJournalDto;

public interface DiagnosticDocumentService {

    void save(ResponseTasksJournalDto taskJournal);

    void update(ResponseTasksJournalDto taskJournal);

    void existsByTaskJournalId(Long taskJournalId);
}