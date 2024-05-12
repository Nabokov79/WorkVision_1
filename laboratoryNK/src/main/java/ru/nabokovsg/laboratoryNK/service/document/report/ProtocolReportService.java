package ru.nabokovsg.laboratoryNK.service.document.report;

import ru.nabokovsg.laboratoryNK.model.document.report.Section;
import ru.nabokovsg.laboratoryNK.model.laboratoryEmployee.LaboratoryEmployee;
import ru.nabokovsg.laboratoryNK.model.template.report.ProtocolReportTemplate;

import java.util.Set;

public interface ProtocolReportService {

    void save(Section section, Set<LaboratoryEmployee> employees, Set<ProtocolReportTemplate> protocolReportTemplates);
}