package ru.nabokovsg.laboratoryNK.mapper.document;

import org.mapstruct.Mapper;
import ru.nabokovsg.laboratoryNK.model.document.DocumentTable;
import ru.nabokovsg.laboratoryNK.model.document.report.ProtocolReport;
import ru.nabokovsg.laboratoryNK.model.template.TableTemplate;

@Mapper(componentModel = "spring")
public interface TableMapper {

    DocumentTable mapToDocumentTable(TableTemplate tableTemplate);

    DocumentTable mapWithProtocolReport(TableTemplate tableTemplate, ProtocolReport protocolReport);
}