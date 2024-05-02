package ru.nabokovsg.laboratoryNK.mapper.template;

import org.mapstruct.Mapper;
import ru.nabokovsg.laboratoryNK.dto.template.appendices.AppendicesDto;
import ru.nabokovsg.laboratoryNK.dto.template.appendices.ResponseAppendicesDto;
import ru.nabokovsg.laboratoryNK.model.template.Appendices;

@Mapper(componentModel = "spring")
public interface AppendicesMapper {

    Appendices mapToAppendicesTemplate(AppendicesDto appendicesDto, String nameOfList);

    ResponseAppendicesDto mapToResponseAppendicesDto(Appendices appendices);
}