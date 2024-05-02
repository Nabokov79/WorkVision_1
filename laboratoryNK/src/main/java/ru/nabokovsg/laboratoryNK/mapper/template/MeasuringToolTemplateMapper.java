package ru.nabokovsg.laboratoryNK.mapper.template;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.dto.template.measuringToolTemplate.ResponseMeasuringToolTemplateDto;
import ru.nabokovsg.laboratoryNK.model.common.MeasuringTool;
import ru.nabokovsg.laboratoryNK.model.template.MeasuringToolTemplate;
import ru.nabokovsg.laboratoryNK.model.template.SubsectionTemplate;

@Mapper(componentModel = "spring")
public interface MeasuringToolTemplateMapper {

    @Mapping(source = "measuringTool.toll", target = "toll")
    @Mapping(source = "measuringTool.model", target = "model")
    @Mapping(source = "tool", target = "measuringTool")
    @Mapping(target = "sequentialNumber", ignore = true)
    @Mapping(target = "subsectionTemplate", ignore = true)
    @Mapping(target = "id", ignore = true)
    MeasuringToolTemplate mapToMeasuringToolTemplate(MeasuringTool measuringTool, String tool);

    @Mapping(source = "measuringTool.toll", target = "toll")
    @Mapping(source = "measuringTool.model", target = "model")
    @Mapping(source = "tool", target = "measuringTool")
    @Mapping(source = "template.sequentialNumber", target = "sequentialNumber")
    @Mapping(source = "template.subsectionTemplate", target = "subsectionTemplate")
    @Mapping(source = "template.id", target = "id")
    MeasuringToolTemplate mapToUpdateMeasuringToolTemplate(MeasuringToolTemplate template
                                                         , MeasuringTool measuringTool
                                                         , String tool);

    ResponseMeasuringToolTemplateDto mapToResponseMeasuringToolTemplateDto(MeasuringToolTemplate template);

    @Mapping(source = "template.toll", target = "toll")
    @Mapping(source = "template.model", target = "model")
    @Mapping(source = "template.measuringTool", target = "measuringTool")
    @Mapping(source = "sequentialNumber", target = "sequentialNumber")
    @Mapping(source = "subsectionTemplate", target = "subsectionTemplate")
    @Mapping(source = "template.id", target = "id")
    MeasuringToolTemplate mapWithSubsectionTemplate(MeasuringToolTemplate template
            , SubsectionTemplate subsectionTemplate
            , Integer sequentialNumber);
}