package ru.nabokovsg.laboratoryNK.service.template.report;

import ru.nabokovsg.laboratoryNK.dto.template.report.section.ResponseSectionTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.report.section.SectionTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.report.section.ShortResponseSectionTemplateDto;

import java.util.List;

public interface SectionTemplateService {

    ResponseSectionTemplateDto save(SectionTemplateDto sectionDto);

    ResponseSectionTemplateDto update(SectionTemplateDto sectionDto);

    ResponseSectionTemplateDto get(Long id);

    List<ShortResponseSectionTemplateDto> getAll(Long id);

    void delete(Long id);
}