package ru.nabokovsg.laboratoryNK.service.template;

import ru.nabokovsg.laboratoryNK.dto.template.conclusion.ConclusionTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.conclusion.ResponseConclusionTemplateDto;
import ru.nabokovsg.laboratoryNK.model.template.ConclusionTemplate;

public interface ConclusionTemplateService {

    ResponseConclusionTemplateDto save(ConclusionTemplateDto conclusionDto);

    ResponseConclusionTemplateDto update(ConclusionTemplateDto conclusionDto);

    ResponseConclusionTemplateDto get(Long id);

    ConclusionTemplate getByDocumentTypeId(Long documentTypeId);

    void delete(Long id);
}