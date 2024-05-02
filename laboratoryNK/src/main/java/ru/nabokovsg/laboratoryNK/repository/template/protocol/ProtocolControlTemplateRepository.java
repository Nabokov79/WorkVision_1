package ru.nabokovsg.laboratoryNK.repository.template.protocol;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.template.protocol.ProtocolControlTemplate;

public interface ProtocolControlTemplateRepository extends JpaRepository<ProtocolControlTemplate, Long> {

    boolean existsByDocumentTypeId(Long documentTypeId);
}