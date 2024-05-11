package ru.nabokovsg.laboratoryNK.mapper.template;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.nabokovsg.laboratoryNK.dto.template.appendices.AppendicesTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.appendices.ResponseAppendicesTemplateDto;
import ru.nabokovsg.laboratoryNK.model.template.AppendicesTemplate;
import ru.nabokovsg.laboratoryNK.model.template.protocol.ProtocolTemplate;
import ru.nabokovsg.laboratoryNK.model.template.report.ReportTemplate;

@Mapper(componentModel = "spring")
public interface AppendicesTemplateMapper {

    AppendicesTemplate mapToAppendicesTemplate(AppendicesTemplateDto appendicesDto, String nameOfList);

    ResponseAppendicesTemplateDto mapToResponseAppendicesDto(AppendicesTemplate appendices);

    @Mapping(source = "reportTemplate", target = "reportTemplate")
    AppendicesTemplate mapWithReportTemplate(@MappingTarget AppendicesTemplate appendices
                                                          , ReportTemplate reportTemplate);

    @Mapping(source = "protocolTemplate", target = "protocolTemplate")
    AppendicesTemplate mapWithProtocolTemplate(@MappingTarget AppendicesTemplate appendices
                                                            , ProtocolTemplate protocolTemplate);
}