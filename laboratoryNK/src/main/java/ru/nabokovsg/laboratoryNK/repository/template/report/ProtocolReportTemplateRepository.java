package ru.nabokovsg.laboratoryNK.repository.template.report;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.template.report.ProtocolReportTemplate;

public interface ProtocolReportTemplateRepository extends JpaRepository<ProtocolReportTemplate, Long> {

    ProtocolReportTemplate findByDocumentTypeId(Long documentTypeId);
}