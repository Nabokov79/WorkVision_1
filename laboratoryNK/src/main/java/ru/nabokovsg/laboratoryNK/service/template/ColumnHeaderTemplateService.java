package ru.nabokovsg.laboratoryNK.service.template;

import ru.nabokovsg.laboratoryNK.dto.template.columnHeader.ColumnHeaderTemplateDto;
import ru.nabokovsg.laboratoryNK.model.template.ColumnHeaderTemplate;
import ru.nabokovsg.laboratoryNK.model.template.TableTemplate;

import java.util.List;

public interface ColumnHeaderTemplateService {

    List<ColumnHeaderTemplate> save(TableTemplate tableTemplate, List<ColumnHeaderTemplateDto> columnHeaderTemplatesDto);

    List<ColumnHeaderTemplate> update(TableTemplate tableTemplate, List<ColumnHeaderTemplateDto> columnHeaderTemplatesDto);
}