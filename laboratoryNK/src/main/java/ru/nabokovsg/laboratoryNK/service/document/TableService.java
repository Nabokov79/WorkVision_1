package ru.nabokovsg.laboratoryNK.service.document;

import ru.nabokovsg.laboratoryNK.model.document.DocumentTable;
import ru.nabokovsg.laboratoryNK.model.document.report.ProtocolReport;
import ru.nabokovsg.laboratoryNK.model.template.TableTemplate;

import java.util.Set;

public interface TableService {

    DocumentTable savaForSubsection(TableTemplate tableTemplate);

    void savaForProtocolReport(ProtocolReport protocol, Set<TableTemplate> templates);
}