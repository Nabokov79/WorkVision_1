package ru.nabokovsg.laboratoryNK.service.template;

import ru.nabokovsg.laboratoryNK.dto.template.appendices.AppendicesTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.appendices.ResponseAppendicesTemplateDto;
import ru.nabokovsg.laboratoryNK.model.template.protocol.ProtocolTemplate;
import ru.nabokovsg.laboratoryNK.model.template.report.ReportTemplate;

public interface AppendicesTemplateService {

    ResponseAppendicesTemplateDto save(AppendicesTemplateDto appendicesDto);

    ResponseAppendicesTemplateDto update(AppendicesTemplateDto appendicesDto);

    void delete(Long id);

    void addReportTemplate(ReportTemplate reportTemplate);

    void addProtocolTemplate(ProtocolTemplate protocolTemplate);
}