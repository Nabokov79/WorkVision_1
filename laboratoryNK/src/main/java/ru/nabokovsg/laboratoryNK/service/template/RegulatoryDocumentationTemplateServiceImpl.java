package ru.nabokovsg.laboratoryNK.service.template;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.dto.template.regulatoryDocumentationTemplate.RegulatoryDocumentationTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.regulatoryDocumentationTemplate.ResponseRegulatoryDocumentationTemplateDto;
import ru.nabokovsg.laboratoryNK.exceptions.NotFoundException;
import ru.nabokovsg.laboratoryNK.mapper.template.RegulatoryDocumentationTemplateMapper;
import ru.nabokovsg.laboratoryNK.model.common.Documentation;
import ru.nabokovsg.laboratoryNK.model.template.RegulatoryDocumentationTemplate;
import ru.nabokovsg.laboratoryNK.model.template.SubsectionTemplate;
import ru.nabokovsg.laboratoryNK.repository.template.RegulatoryDocumentationTemplateRepository;
import ru.nabokovsg.laboratoryNK.service.common.StringBuilderService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegulatoryDocumentationTemplateServiceImpl implements RegulatoryDocumentationTemplateService {

    private final RegulatoryDocumentationTemplateRepository repository;
    private final RegulatoryDocumentationTemplateMapper mapper;
    private final StringBuilderService stringBuilderService;

    @Override
    public void save(Documentation documentation) {
        repository.save(
                mapper.mapToRegulatoryDocumentationTemplate(documentation
                                                          , stringBuilderService.buildDocumentation(documentation))
        );
    }

    @Override
    public void update(Documentation documentation) {
        RegulatoryDocumentationTemplate template = repository.findByDocumentationId(documentation.getId());
        if (template != null) {
            repository.save(
                    mapper.mapToUpdateRegulatoryDocumentationTemplate(template
                                                               , documentation
                                                               , stringBuilderService.buildDocumentation(documentation))
            );
        }
    }

    @Override
    public void saveWithSubsectionTemplate(SubsectionTemplate template, List<RegulatoryDocumentationTemplateDto> documentations) {
        Map<Long, RegulatoryDocumentationTemplate> templates = repository.findAllById(
                                            documentations.stream()
                                                    .map(RegulatoryDocumentationTemplateDto::getTemplateId)
                                                    .toList())
                                            .stream()
                                            .collect(Collectors.toMap(RegulatoryDocumentationTemplate::getId, r -> r));
        if (!templates.isEmpty()) {
            repository.saveAll(documentations.stream()
                    .map(d -> mapper.mapToWithSubsectionTemplate(templates.get(d.getTemplateId())
                                                               , template
                                                               , d.getSequentialNumber()))
                    .toList());
        }
    }

    @Override
    public List<ResponseRegulatoryDocumentationTemplateDto> getAll() {
        return repository.findAll()
                         .stream()
                         .map(mapper::mapToResponseRegulatoryDocumentationTemplateDto)
                         .toList();
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(
                String.format("RegulatoryDocumentation template with id=%s not found for delete", id)
        );
    }
}