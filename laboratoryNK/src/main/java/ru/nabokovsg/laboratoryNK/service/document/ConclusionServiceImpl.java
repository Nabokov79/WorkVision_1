package ru.nabokovsg.laboratoryNK.service.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.mapper.document.ConclusionMapper;
import ru.nabokovsg.laboratoryNK.model.document.Conclusion;
import ru.nabokovsg.laboratoryNK.model.template.ConclusionTemplate;
import ru.nabokovsg.laboratoryNK.repository.document.ConclusionRepository;

@Service
@RequiredArgsConstructor
public class ConclusionServiceImpl implements ConclusionService {

    private final ConclusionRepository repository;
    private final ConclusionMapper mapper;

    @Override
    public Conclusion save(ConclusionTemplate template) {
        return repository.save(mapper.mapToConclusion(template));
    }
}