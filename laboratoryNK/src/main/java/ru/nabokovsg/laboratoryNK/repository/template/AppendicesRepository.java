package ru.nabokovsg.laboratoryNK.repository.template;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.template.Appendices;

public interface AppendicesRepository extends JpaRepository<Appendices, Long> {

    Appendices findByAppendicesName(String appendicesName);
}