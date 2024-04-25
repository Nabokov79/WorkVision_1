package ru.nabokovsg.laboratoryNK.service;

import ru.nabokovsg.laboratoryNK.dto.tasksJournal.ResponseTasksJournalDto;
import ru.nabokovsg.laboratoryNK.dto.tasksJournal.TasksJournalDto;

import java.time.LocalDate;
import java.util.List;

public interface TasksJournalService {

    ResponseTasksJournalDto save(TasksJournalDto taskJournalDto);

    ResponseTasksJournalDto update(TasksJournalDto taskJournalDto);

    List<ResponseTasksJournalDto> getAll(LocalDate startPeriod, LocalDate endPeriod);

    void delete(Long id);
}