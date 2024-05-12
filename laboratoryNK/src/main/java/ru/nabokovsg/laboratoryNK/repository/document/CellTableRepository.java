package ru.nabokovsg.laboratoryNK.repository.document;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.document.CellTable;

public interface CellTableRepository extends JpaRepository<CellTable, Long> {
}