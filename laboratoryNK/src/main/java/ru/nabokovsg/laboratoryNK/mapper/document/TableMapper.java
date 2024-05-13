package ru.nabokovsg.laboratoryNK.mapper.document;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.model.document.DocumentTable;
import ru.nabokovsg.laboratoryNK.model.document.report.ProtocolReport;
import ru.nabokovsg.laboratoryNK.model.template.TableTemplate;

@Mapper(componentModel = "spring")
public interface TableMapper {

    DocumentTable mapToDocumentTable(TableTemplate tableTemplate);

    @Mapping(source = "tableTemplate.sequentialNumber", target = "sequentialNumber")
    @Mapping(source = "tableTemplate.tableName", target = "tableName")
    @Mapping(source = "tableTemplate.textBeforeTable", target = "textBeforeTable")
    @Mapping(source = "tableTemplate.textAfterTable", target = "textAfterTable")
    @Mapping(source = "protocolReport", target = " protocolReport")
    @Mapping(target = "id", ignore = true)
    DocumentTable mapWithProtocolReport(TableTemplate tableTemplate, ProtocolReport protocolReport);
}