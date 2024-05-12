package ru.nabokovsg.laboratoryNK.service.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.mapper.document.DocumentHeaderMapper;
import ru.nabokovsg.laboratoryNK.model.document.report.PageTitle;
import ru.nabokovsg.laboratoryNK.model.template.DocumentHeaderTemplate;
import ru.nabokovsg.laboratoryNK.repository.document.DocumentHeaderRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class DocumentHeaderServiceImpl implements DocumentHeaderService {

    private final DocumentHeaderRepository repository;
    private final DocumentHeaderMapper mapper;

    @Override
    public void saveForPageTitle(PageTitle pageTitle, Set<DocumentHeaderTemplate> documentHeaders) {
        repository.saveAll(documentHeaders.stream()
                                          .map(mapper::mapToDocumentHeader)
                                          .map(h -> mapper.mapWithPageTitle(h, pageTitle))
                                          .toList());
    }
}