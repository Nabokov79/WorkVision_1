package ru.nabokovsg.laboratoryNK.mapper.template;

import org.mapstruct.Mapper;
import ru.nabokovsg.laboratoryNK.model.template.ConclusionTemplate;
import ru.nabokovsg.laboratoryNK.dto.template.conclusion.ConclusionTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.conclusion.ResponseConclusionTemplateDto;

@Mapper(componentModel = "spring")
public interface ConclusionTemplateMapper {

    ConclusionTemplate mapToConclusionTemplate(ConclusionTemplateDto conclusionDto);

    ResponseConclusionTemplateDto mapToResponseConclusionTemplateDto(ConclusionTemplate conclusion);
}