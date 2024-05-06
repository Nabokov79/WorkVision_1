package ru.nabokovsg.laboratoryNK.service.template.report;

import ru.nabokovsg.laboratoryNK.dto.template.report.protocolReport.ProtocolReportTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.report.protocolReport.ResponseProtocolReportTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.report.protocolReport.ShortResponseProtocolReportTemplateDto;
import ru.nabokovsg.laboratoryNK.model.template.report.SectionTemplate;

import java.util.List;

public interface ProtocolReportTemplateService {

    ShortResponseProtocolReportTemplateDto save(ProtocolReportTemplateDto protocolDto);

    ShortResponseProtocolReportTemplateDto update(ProtocolReportTemplateDto protocolDto);

    ResponseProtocolReportTemplateDto get(Long id);

    List<ShortResponseProtocolReportTemplateDto> getAll(Long id);

    void delete(Long id);

    void addSectionTemplate(SectionTemplate template, List<Long> protocolReportTemplatesId);
}