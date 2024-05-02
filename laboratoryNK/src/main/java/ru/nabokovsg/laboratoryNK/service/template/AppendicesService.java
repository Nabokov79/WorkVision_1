package ru.nabokovsg.laboratoryNK.service.template;

import ru.nabokovsg.laboratoryNK.dto.template.appendices.AppendicesDto;
import ru.nabokovsg.laboratoryNK.dto.template.appendices.ResponseAppendicesDto;

public interface AppendicesService {

    ResponseAppendicesDto save(AppendicesDto appendicesDto);

    ResponseAppendicesDto update(AppendicesDto appendicesDto);

    void delete(Long id);
}