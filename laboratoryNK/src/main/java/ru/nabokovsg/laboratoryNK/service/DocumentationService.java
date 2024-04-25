package ru.nabokovsg.laboratoryNK.service;

import ru.nabokovsg.laboratoryNK.dto.documentation.DocumentationDto;

import java.util.List;

public interface DocumentationService {

    DocumentationDto save(DocumentationDto documentationDto);

    DocumentationDto update(DocumentationDto documentationDto);

    List<DocumentationDto> getAll(List<Long> ids, String number, String title);

   void delete(Long id);
}