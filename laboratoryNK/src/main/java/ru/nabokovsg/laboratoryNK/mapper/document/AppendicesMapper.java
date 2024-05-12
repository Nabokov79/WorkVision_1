package ru.nabokovsg.laboratoryNK.mapper.document;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.model.document.Appendices;
import ru.nabokovsg.laboratoryNK.model.document.protocol.SurveyProtocol;
import ru.nabokovsg.laboratoryNK.model.document.report.Report;
import ru.nabokovsg.laboratoryNK.model.template.AppendicesTemplate;

@Mapper(componentModel = "spring")
public interface AppendicesMapper {

    @Mapping(target = "id", ignore = true)
    Appendices mapWithReport(AppendicesTemplate template, Report report);

    @Mapping(target = "id", ignore = true)
    Appendices mapWithSurveyProtocol(AppendicesTemplate template, SurveyProtocol protocol);
}