package ru.nabokovsg.laboratoryNK.service.template;

import ru.nabokovsg.laboratoryNK.dto.template.measuringToolTemplate.MeasuringToolTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.measuringToolTemplate.ResponseMeasuringToolTemplateDto;
import ru.nabokovsg.laboratoryNK.model.common.MeasuringTool;
import ru.nabokovsg.laboratoryNK.model.template.SubsectionTemplate;

import java.util.List;

public interface MeasuringToolTemplateService {

    void save(MeasuringTool measuringTool);

    void update(MeasuringTool measuringTool);

    void saveWithSubsectionTemplate(SubsectionTemplate template, List<MeasuringToolTemplateDto> measuringTools);

    List<ResponseMeasuringToolTemplateDto> getAll();

    void delete(Long id);
}