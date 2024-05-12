package ru.nabokovsg.laboratoryNK.service.template;

import ru.nabokovsg.laboratoryNK.dto.template.table.ResponseTableTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.table.TableTemplateDto;
import ru.nabokovsg.laboratoryNK.model.template.TableTemplate;
import ru.nabokovsg.laboratoryNK.model.template.protocol.ProtocolControlTemplate;
import ru.nabokovsg.laboratoryNK.model.template.protocol.SurveyProtocolTemplate;
import ru.nabokovsg.laboratoryNK.model.template.report.ProtocolReportTemplate;

import java.util.List;

public interface TableTemplateService {

    ResponseTableTemplateDto save(TableTemplateDto tableDto);

    ResponseTableTemplateDto update(TableTemplateDto tableDto);

    ResponseTableTemplateDto get(Long id);

    TableTemplate getById(Long id);

    void delete(Long id);

    void addProtocolReportTemplate(ProtocolReportTemplate template, List<Long> tableTemplatesId);

    void addProtocolTemplate(SurveyProtocolTemplate template, List<Long> tableTemplatesId);

    void addProtocolControlTemplate(ProtocolControlTemplate template, List<Long> tableTemplatesId);
}