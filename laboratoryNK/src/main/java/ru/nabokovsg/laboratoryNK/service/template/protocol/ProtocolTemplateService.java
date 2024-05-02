package ru.nabokovsg.laboratoryNK.service.template.protocol;

import ru.nabokovsg.laboratoryNK.dto.template.protocol.ProtocolTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.protocol.ResponseProtocolTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.protocol.ShortResponseProtocolTemplateDto;

import java.util.List;

public interface ProtocolTemplateService {

    ShortResponseProtocolTemplateDto save(ProtocolTemplateDto protocolDto);

    ShortResponseProtocolTemplateDto update(ProtocolTemplateDto protocolDto);

    ResponseProtocolTemplateDto get(Long id);

    List<ShortResponseProtocolTemplateDto> getAll();

    void delete(Long id);
}