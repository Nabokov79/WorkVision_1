package ru.nabokovsg.laboratoryNK.service.template.protocol;

import ru.nabokovsg.laboratoryNK.dto.template.surveyProtocol.ResponseSurveyProtocolTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.surveyProtocol.ShortResponseSurveyProtocolTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.surveyProtocol.SurveyProtocolTemplateDto;

import java.util.List;

public interface SurveyProtocolTemplateService {

    ShortResponseSurveyProtocolTemplateDto save(SurveyProtocolTemplateDto protocolDto);

    ShortResponseSurveyProtocolTemplateDto update(SurveyProtocolTemplateDto protocolDto);

    ResponseSurveyProtocolTemplateDto get(Long id);

   List<ShortResponseSurveyProtocolTemplateDto> getAll();

    void delete(Long id);
}