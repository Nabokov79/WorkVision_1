package ru.nabokovsg.laboratoryNK.service.template.protocol;

import ru.nabokovsg.laboratoryNK.dto.template.protocolControl.ProtocolControlTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.protocolControl.ResponseProtocolControlTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.protocolControl.ShortResponseProtocolControlTemplateDto;

import java.util.List;

public interface ProtocolControlTemplateService {

    ShortResponseProtocolControlTemplateDto save(ProtocolControlTemplateDto protocolDto);

    ShortResponseProtocolControlTemplateDto update(ProtocolControlTemplateDto protocolDto);

    ResponseProtocolControlTemplateDto get(Long id);

    List<ShortResponseProtocolControlTemplateDto> getAll();

    void delete(Long id);
}