package ru.nabokovsg.laboratoryNK.repository.template.protocol;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.template.protocol.SurveyProtocolTemplate;

public interface SurveyProtocolTemplateRepository extends JpaRepository<SurveyProtocolTemplate, Long> {

    boolean existsByDocumentTypeIdAndEquipmentTypeId(Long documentTypeId, Long equipmentTypeId);
}