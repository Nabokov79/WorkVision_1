package ru.nabokovsg.laboratoryNK.repository.document;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.document.DocumentHeader;

public interface DocumentHeaderRepository extends JpaRepository<DocumentHeader, Long> {
}