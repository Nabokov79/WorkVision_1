package ru.nabokovsg.laboratoryNK.mapper.document;

import org.mapstruct.Mapper;
import ru.nabokovsg.laboratoryNK.model.document.Conclusion;
import ru.nabokovsg.laboratoryNK.model.template.ConclusionTemplate;

@Mapper(componentModel = "spring")
public interface ConclusionMapper {

    Conclusion mapToConclusion(ConclusionTemplate template);
}