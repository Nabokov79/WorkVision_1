package ru.nabokovsg.laboratoryNK.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.TasksJournal;

import java.time.LocalDate;

public interface TasksJournalRepository extends JpaRepository<TasksJournal, Long> {

    TasksJournal findByDateAndEquipmentId(LocalDate date, Long equipmentId);
}