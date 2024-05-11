package ru.nabokovsg.laboratoryNK.service.template;

import ru.nabokovsg.laboratoryNK.dto.template.appendices.AppendicesTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.appendices.ResponseAppendicesTemplateDto;

public interface AppendicesTemplateService {

    ResponseAppendicesTemplateDto save(AppendicesTemplateDto appendicesDto);

    ResponseAppendicesTemplateDto update(AppendicesTemplateDto appendicesDto);

    void delete(Long id);
}