package ru.nabokovsg.laboratoryNK.repository.document;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.document.Appendices;

public interface AppendicesRepository extends JpaRepository<Appendices, Long> {
}