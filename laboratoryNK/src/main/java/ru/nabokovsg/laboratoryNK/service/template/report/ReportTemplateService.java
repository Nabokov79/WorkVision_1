package ru.nabokovsg.laboratoryNK.service.template.report;

import ru.nabokovsg.laboratoryNK.dto.template.report.ResponseReportTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.report.ShortResponseReportTemplateDto;
import ru.nabokovsg.laboratoryNK.model.template.report.PageTitleTemplate;
import ru.nabokovsg.laboratoryNK.model.template.report.ReportTemplate;

import java.util.List;

public interface ReportTemplateService {

    ResponseReportTemplateDto get(Long id);

    List<ShortResponseReportTemplateDto> getAll();

    void save(Long documentTypeId, Long equipmentTypeId, PageTitleTemplate template);

    void validateByIds(Long documentTypeId, Long equipmentTypeId);

    ReportTemplate getByDocumentTypeIdAndEquipmentTypeId(Long documentTypeId, Long equipmentTypeId);
}