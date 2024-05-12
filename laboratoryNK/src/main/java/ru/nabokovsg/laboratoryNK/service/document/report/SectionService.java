package ru.nabokovsg.laboratoryNK.service.document.report;

import ru.nabokovsg.laboratoryNK.model.document.report.Report;
import ru.nabokovsg.laboratoryNK.model.laboratoryEmployee.LaboratoryEmployee;
import ru.nabokovsg.laboratoryNK.model.template.report.ReportTemplate;
import java.util.Set;

public interface SectionService {

    void save(Report report, ReportTemplate template, Set<LaboratoryEmployee> employees);
}