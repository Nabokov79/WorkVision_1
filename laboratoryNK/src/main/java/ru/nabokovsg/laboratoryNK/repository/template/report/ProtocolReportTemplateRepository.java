package ru.nabokovsg.laboratoryNK.repository.template.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.nabokovsg.laboratoryNK.model.template.report.ProtocolReportTemplate;

import java.util.Set;

public interface ProtocolReportTemplateRepository extends JpaRepository<ProtocolReportTemplate, Long> {

    ProtocolReportTemplate findByDocumentTypeId(Long documentTypeId);

    @Query("select s.protocolReportTemplates from SectionTemplate s where s.id=?1")
    Set<ProtocolReportTemplate> findAllBySectionId(Long sectionId);
}