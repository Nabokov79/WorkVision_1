package ru.nabokovsg.laboratoryNK.mapper.document;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.model.document.RegulatoryDocumentation;
import ru.nabokovsg.laboratoryNK.model.document.Subsection;
import ru.nabokovsg.laboratoryNK.model.template.RegulatoryDocumentationTemplate;

@Mapper(componentModel = "spring")
public interface RegulatoryDocumentationMapper {

    @Mapping(source = "template.sequentialNumber", target = "sequentialNumber")
    @Mapping(source = "template.documentName", target = "documentName")
    @Mapping(source = "subsection", target = "subsection")
    @Mapping(target = "id", ignore = true)
    RegulatoryDocumentation mapToRegulatoryDocumentation(RegulatoryDocumentationTemplate template
                                                       , Subsection subsection);
}