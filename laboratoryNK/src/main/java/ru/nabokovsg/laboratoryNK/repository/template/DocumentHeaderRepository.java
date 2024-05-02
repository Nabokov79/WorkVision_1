package ru.nabokovsg.laboratoryNK.repository.template;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.template.DivisionType;
import ru.nabokovsg.laboratoryNK.model.template.DocumentHeader;

import java.util.Set;

public interface DocumentHeaderRepository extends JpaRepository<DocumentHeader, Long> {

    Set<DocumentHeader> findAllByDocumentTypeId(Long documentTypeId);

    DocumentHeader findByDocumentTypeIdAndDivisionType(Long documentTypeId, DivisionType divisionType);
}