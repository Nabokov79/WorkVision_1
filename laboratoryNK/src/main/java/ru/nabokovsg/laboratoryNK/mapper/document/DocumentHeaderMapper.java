package ru.nabokovsg.laboratoryNK.mapper.document;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.nabokovsg.laboratoryNK.model.document.DocumentHeader;
import ru.nabokovsg.laboratoryNK.model.document.report.PageTitle;
import ru.nabokovsg.laboratoryNK.model.template.DocumentHeaderTemplate;

@Mapper(componentModel = "spring")
public interface DocumentHeaderMapper {

    DocumentHeader mapToDocumentHeader(DocumentHeaderTemplate documentHeaders);

    @Mapping(source = "pageTitle", target = "pageTitle")
    DocumentHeader mapWithPageTitle(@MappingTarget DocumentHeader documentHeaders, PageTitle pageTitle);
}
