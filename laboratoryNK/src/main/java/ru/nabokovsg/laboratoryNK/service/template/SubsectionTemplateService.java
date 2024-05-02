package ru.nabokovsg.laboratoryNK.service.template;

import ru.nabokovsg.laboratoryNK.dto.template.subsectionTemplate.ResponseSubsectionTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.subsectionTemplate.SubsectionTemplateDto;
import ru.nabokovsg.laboratoryNK.model.template.protocol.ProtocolControlTemplate;
import ru.nabokovsg.laboratoryNK.model.template.protocol.ProtocolTemplate;
import ru.nabokovsg.laboratoryNK.model.template.report.ProtocolReportTemplate;
import ru.nabokovsg.laboratoryNK.model.template.report.SectionTemplate;

import java.util.List;

public interface SubsectionTemplateService {

    ResponseSubsectionTemplateDto save(SubsectionTemplateDto subsectionsDto);

    ResponseSubsectionTemplateDto update(SubsectionTemplateDto subsectionsDto);

    ResponseSubsectionTemplateDto get(Long id);

    void delete(Long id);

    void addProtocolReportTemplate(ProtocolReportTemplate template, List<Long> subsectionTemplatesId);

    void addSectionTemplate(SectionTemplate template, List<Long> subsectionTemplatesId);

    void addProtocolTemplate(ProtocolTemplate template, List<Long> subsectionTemplatesId);

    void addProtocolControlTemplate(ProtocolControlTemplate template, List<Long> subsectionTemplatesId);
}