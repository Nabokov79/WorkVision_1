package ru.nabokovsg.laboratoryNK.service.document;

import ru.nabokovsg.laboratoryNK.model.document.report.ProtocolReport;
import ru.nabokovsg.laboratoryNK.model.document.report.Section;
import ru.nabokovsg.laboratoryNK.model.laboratoryEmployee.LaboratoryEmployee;
import ru.nabokovsg.laboratoryNK.model.template.SubsectionTemplate;

import java.util.Set;

public interface SubsectionService {

    void saveForSection(Section section, Set<LaboratoryEmployee> employees
                                       , Set<SubsectionTemplate> subsectionTemplates);

    void saveFoProtocolReport(ProtocolReport protocol, Set<LaboratoryEmployee> employees
                                                     , Set<SubsectionTemplate> subsectionTemplates);
}