package ru.nabokovsg.laboratoryNK.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.TasksJournal;

import java.time.LocalDate;

public interface TasksJournalRepository extends JpaRepository<TasksJournal, Long> {

    boolean existsByDateAndEquipmentId(LocalDate date, Long equipmentId);
}