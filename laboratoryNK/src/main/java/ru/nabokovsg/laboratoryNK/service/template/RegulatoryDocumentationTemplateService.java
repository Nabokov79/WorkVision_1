package ru.nabokovsg.laboratoryNK.service.template;

import ru.nabokovsg.laboratoryNK.dto.template.regulatoryDocumentationTemplate.RegulatoryDocumentationTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.regulatoryDocumentationTemplate.ResponseRegulatoryDocumentationTemplateDto;
import ru.nabokovsg.laboratoryNK.model.common.Documentation;
import ru.nabokovsg.laboratoryNK.model.template.SubsectionTemplate;

import java.util.List;

public interface RegulatoryDocumentationTemplateService {

    void save(Documentation documentation);

    void update(Documentation documentation);

    void saveWithSubsectionTemplate(SubsectionTemplate template
                                  , List<RegulatoryDocumentationTemplateDto> documentations);

    List<ResponseRegulatoryDocumentationTemplateDto> getAll();

   void delete(Long id);
}