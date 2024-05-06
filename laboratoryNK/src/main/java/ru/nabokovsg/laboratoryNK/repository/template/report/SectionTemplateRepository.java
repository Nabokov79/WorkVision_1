package ru.nabokovsg.laboratoryNK.repository.template.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.nabokovsg.laboratoryNK.model.template.report.SectionTemplate;

import java.util.Set;

public interface SectionTemplateRepository extends JpaRepository<SectionTemplate, Long> {

    @Query("select t.sectionsTemplate from ReportTemplate t where t.id=?1")
    Set<SectionTemplate> findByReportTemplateId(Long id);
}