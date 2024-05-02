package ru.nabokovsg.laboratoryNK.mapper.template.report;

import org.mapstruct.Mapper;
import ru.nabokovsg.laboratoryNK.dto.template.report.section.ResponseSectionTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.report.section.SectionTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.report.section.ShortResponseSectionTemplateDto;
import ru.nabokovsg.laboratoryNK.model.template.report.SectionTemplate;

@Mapper(componentModel = "spring")
public interface SectionTemplateMapper {

    SectionTemplate mapToSectionTemplate(SectionTemplateDto sectionDto);

    ResponseSectionTemplateDto mapToResponseSectionTemplateDto(SectionTemplate section);

    ShortResponseSectionTemplateDto mapToShortResponseSectionTemplateDto(SectionTemplate section);
}