package ru.nabokovsg.laboratoryNK.repository.document;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.document.Conclusion;

public interface ConclusionRepository extends JpaRepository<Conclusion, Long> {
}