package ru.nabokovsg.laboratoryNK.service.template;

import ru.nabokovsg.laboratoryNK.dto.template.documentHeader.DocumentHeaderDto;
import ru.nabokovsg.laboratoryNK.dto.template.documentHeader.ResponseDocumentHeaderDto;
import ru.nabokovsg.laboratoryNK.model.template.DocumentHeader;

import java.util.List;
import java.util.Set;

public interface DocumentHeaderService {

    ResponseDocumentHeaderDto save(DocumentHeaderDto headerDto);

    ResponseDocumentHeaderDto update(DocumentHeaderDto headerDto);

    List<ResponseDocumentHeaderDto> getAll(Long id);

    Set<DocumentHeader> getAllByDocumentTypeId(Long documentTypeId);

    void delete(Long id);
}