package ru.nabokovsg.laboratoryNK.service.document;

import ru.nabokovsg.laboratoryNK.model.document.protocol.SurveyProtocol;
import ru.nabokovsg.laboratoryNK.model.document.report.Report;
import ru.nabokovsg.laboratoryNK.model.template.AppendicesTemplate;

import java.util.Set;

public interface AppendicesService {

    void saveForReport(Report report, Set<AppendicesTemplate> templates);

    void saveForSurveyProtocol(SurveyProtocol protocol, Set<AppendicesTemplate> templates);
}