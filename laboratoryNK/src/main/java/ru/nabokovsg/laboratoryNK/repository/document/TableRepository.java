package ru.nabokovsg.laboratoryNK.repository.document;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.document.DocumentTable;

public interface TableRepository extends JpaRepository<DocumentTable, Long> {
}