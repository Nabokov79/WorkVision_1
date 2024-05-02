package ru.nabokovsg.laboratoryNK.repository.template.protocol;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.template.protocol.ProtocolTemplate;

public interface ProtocolTemplateRepository extends JpaRepository<ProtocolTemplate, Long> {

    boolean existsByDocumentTypeIdAndEquipmentTypeId(Long documentTypeId, Long equipmentTypeId);
}