package ru.nabokovsg.laboratoryNK.service.template;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.dto.template.columnHeader.ColumnHeaderTemplateDto;
import ru.nabokovsg.laboratoryNK.exceptions.NotFoundException;
import ru.nabokovsg.laboratoryNK.mapper.template.ColumnHeaderTemplateMapper;
import ru.nabokovsg.laboratoryNK.model.template.ColumnHeaderTemplate;
import ru.nabokovsg.laboratoryNK.model.template.ColumnHeaderType;
import ru.nabokovsg.laboratoryNK.model.template.TableTemplate;
import ru.nabokovsg.laboratoryNK.repository.template.ColumnHeaderTemplateRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColumnHeaderTemplateServiceImpl implements ColumnHeaderTemplateService {

    private final ColumnHeaderTemplateRepository repository;
    private final ColumnHeaderTemplateMapper mapper;

    @Override
    public List<ColumnHeaderTemplate> save(TableTemplate tableTemplate
                                         , List<ColumnHeaderTemplateDto> columnHeaderTemplatesDto) {
        return repository.saveAll(
                columnHeaderTemplatesDto.stream()
                                        .map(t -> {
                                           ColumnHeaderType type = ColumnHeaderType.valueOf(t.getColumnHeaderType());
                                           return mapper.mapToColumnHeaderTemplates(tableTemplate, t, type.label, type);
                                             })
                                       .toList());
    }

    @Override
    public List<ColumnHeaderTemplate> update(TableTemplate tableTemplate
                                           , List<ColumnHeaderTemplateDto> columnHeaderTemplatesDto) {
        validateIds(columnHeaderTemplatesDto.stream()
                                           .map(ColumnHeaderTemplateDto::getId)
                                           .toList());
        return repository.saveAll(
                columnHeaderTemplatesDto.stream()
                        .map(t -> {
                            ColumnHeaderType type = ColumnHeaderType.valueOf(t.getColumnHeaderType());
                            return mapper.mapToColumnHeaderTemplates(tableTemplate, t, type.label, type);
                        })
                        .toList());
    }

    private void validateIds(List<Long> ids) {
        Map<Long, ColumnHeaderTemplate> columnHeaderTemplate = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(ColumnHeaderTemplate::getId, m -> m));
        if (columnHeaderTemplate.size() != ids.size() || columnHeaderTemplate.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(columnHeaderTemplate.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("Column header template with ids= %s not found", ids));

        }
    }
}