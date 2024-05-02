package ru.nabokovsg.laboratoryNK.repository.template;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.template.TableTemplate;

public interface TableTemplateRepository extends JpaRepository<TableTemplate, Long> {
}