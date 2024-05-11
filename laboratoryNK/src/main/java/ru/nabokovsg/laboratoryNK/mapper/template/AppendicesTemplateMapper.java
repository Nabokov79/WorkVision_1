package ru.nabokovsg.laboratoryNK.mapper.template;

import org.mapstruct.Mapper;
import ru.nabokovsg.laboratoryNK.dto.template.appendices.AppendicesTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.appendices.ResponseAppendicesTemplateDto;
import ru.nabokovsg.laboratoryNK.model.template.AppendicesTemplate;

@Mapper(componentModel = "spring")
public interface AppendicesTemplateMapper {

    AppendicesTemplate mapToAppendicesTemplate(AppendicesTemplateDto appendicesDto, String nameOfList);

    ResponseAppendicesTemplateDto mapToResponseAppendicesDto(AppendicesTemplate appendices);
}