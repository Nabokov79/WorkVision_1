package ru.nabokovsg.laboratoryNK.mapper.template;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.dto.template.columnHeader.ColumnHeaderTemplateDto;
import ru.nabokovsg.laboratoryNK.model.template.ColumnHeaderTemplate;
import ru.nabokovsg.laboratoryNK.model.template.ColumnHeaderType;
import ru.nabokovsg.laboratoryNK.model.template.TableTemplate;

@Mapper(componentModel = "spring")
public interface ColumnHeaderTemplateMapper {

    @Mapping(source = "templateDto.id", target = "id")
    @Mapping(source = "templateDto.sequentialNumber", target = "sequentialNumber")
    @Mapping(source = "heading", target = "heading")
    @Mapping(source = "columnHeaderType", target = "columnHeaderType")
    @Mapping(source = "tableTemplate", target = "tableTemplate")
    ColumnHeaderTemplate mapToColumnHeaderTemplates(TableTemplate tableTemplate
                                                  , ColumnHeaderTemplateDto templateDto
                                                  , String heading
                                                  , String columnHeaderType);
}