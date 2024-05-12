package ru.nabokovsg.laboratoryNK.service.template;

import ru.nabokovsg.laboratoryNK.dto.template.documentHeader.DocumentHeaderTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.documentHeader.ResponseDocumentHeaderTemplateDto;
import ru.nabokovsg.laboratoryNK.model.template.DocumentHeaderTemplate;

import java.util.List;
import java.util.Set;

public interface DocumentHeaderTemplateService {

    ResponseDocumentHeaderTemplateDto save(DocumentHeaderTemplateDto headerDto);

    ResponseDocumentHeaderTemplateDto update(DocumentHeaderTemplateDto headerDto);

    List<ResponseDocumentHeaderTemplateDto> getAll(Long id);

    Set<DocumentHeaderTemplate> getAllByDocumentTypeId(Long documentTypeId);

    void delete(Long id);
}