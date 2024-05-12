package ru.nabokovsg.laboratoryNK.mapper.document.report;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.model.document.report.Report;
import ru.nabokovsg.laboratoryNK.model.document.report.Section;
import ru.nabokovsg.laboratoryNK.model.template.report.SectionTemplate;

@Mapper(componentModel = "spring")
public interface SectionMapper {

    @Mapping(source = "template.sequentialNumber", target = "sequentialNumber")
    @Mapping(source = "template.sectionName", target = "sectionName")
    @Mapping(source = "report", target = "report")
    @Mapping(target = "equipmentPassports", ignore = true)
    @Mapping(target = "subsection", ignore = true)
    @Mapping(target = "protocolReport", ignore = true)
    @Mapping(target = "id", ignore = true)
    Section mapToSection(SectionTemplate template, Report report);
}