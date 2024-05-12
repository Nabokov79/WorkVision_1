package ru.nabokovsg.laboratoryNK.service.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.mapper.document.RegulatoryDocumentationMapper;
import ru.nabokovsg.laboratoryNK.model.document.Subsection;
import ru.nabokovsg.laboratoryNK.model.template.RegulatoryDocumentationTemplate;
import ru.nabokovsg.laboratoryNK.repository.document.RegulatoryDocumentationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegulatoryDocumentationServiceImpl implements RegulatoryDocumentationService {

    private final RegulatoryDocumentationRepository repository;
    private final RegulatoryDocumentationMapper mapper;

    @Override
    public void save(Subsection subsection, List<RegulatoryDocumentationTemplate> documentationTemplate) {
        repository.saveAll(documentationTemplate.stream()
                                                .map(d -> mapper.mapToRegulatoryDocumentation(d, subsection))
                                                .toList());
    }
}