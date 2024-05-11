package ru.nabokovsg.laboratoryNK.repository.template;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.template.AppendicesTemplate;

import java.util.Optional;

public interface AppendicesTemplateRepository extends JpaRepository<AppendicesTemplate, Long> {

    AppendicesTemplate findByAppendicesName(String appendicesName);

    Optional<AppendicesTemplate> findByEquipmentTypeId(Long equipmentTypeId);
}