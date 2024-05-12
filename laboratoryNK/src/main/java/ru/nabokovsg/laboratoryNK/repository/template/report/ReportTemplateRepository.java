package ru.nabokovsg.laboratoryNK.repository.template.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.nabokovsg.laboratoryNK.model.template.report.PageTitleTemplate;
import ru.nabokovsg.laboratoryNK.model.template.report.ReportTemplate;

import java.util.Optional;
import java.util.Set;

public interface ReportTemplateRepository extends JpaRepository<ReportTemplate, Long> {

    @Query("select r.pageTitleTemplate from ReportTemplate r")
    Set<PageTitleTemplate> findAllPageTitleTemplate();

    boolean existsByDocumentTypeIdAndEquipmentTypeId(Long documentTypeId, Long equipmentTypeId);

    Optional<ReportTemplate> findByDocumentTypeIdAndEquipmentTypeId(Long documentTypeId, Long equipmentTypeId);
}