package ru.nabokovsg.laboratoryNK.service.template.protocol;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.dto.template.protocol.ProtocolTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.protocol.ResponseProtocolTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.protocol.ShortResponseProtocolTemplateDto;
import ru.nabokovsg.laboratoryNK.exceptions.BadRequestException;
import ru.nabokovsg.laboratoryNK.exceptions.NotFoundException;
import ru.nabokovsg.laboratoryNK.mapper.template.protocol.ProtocolTemplateMapper;
import ru.nabokovsg.laboratoryNK.model.template.protocol.ProtocolTemplate;
import ru.nabokovsg.laboratoryNK.repository.template.protocol.ProtocolTemplateRepository;
import ru.nabokovsg.laboratoryNK.service.diagnosticDocuments.DiagnosticDocumentTypeService;
import ru.nabokovsg.laboratoryNK.service.template.ConclusionTemplateService;
import ru.nabokovsg.laboratoryNK.service.template.DocumentHeaderService;
import ru.nabokovsg.laboratoryNK.service.template.SubsectionTemplateService;
import ru.nabokovsg.laboratoryNK.service.template.TableTemplateService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProtocolTemplateServiceImpl implements ProtocolTemplateService {

    private final ProtocolTemplateRepository repository;
    private final ProtocolTemplateMapper mapper;
    private final DocumentHeaderService documentHeaderService;
    private final DiagnosticDocumentTypeService documentTypeService;
    private final SubsectionTemplateService subsectionService;
    private final TableTemplateService tableService;
    private final ConclusionTemplateService conclusionService;

    @Override
    public ShortResponseProtocolTemplateDto save(ProtocolTemplateDto protocolDto) {
        if (repository.existsByDocumentTypeIdAndEquipmentTypeId(protocolDto.getDocumentTypeId()
                                                              , protocolDto.getEquipmentTypeId())) {
            throw new BadRequestException(
                    String.format("ReportTemplate with documentTypeId=%s equipmentTypeId=%s is found"
                                                                                   , protocolDto.getDocumentTypeId()
                                                                                   , protocolDto.getEquipmentTypeId()));
        }
        ProtocolTemplate template = repository.save(mapper.mapToProtocolTemplate(protocolDto
                                        , documentTypeService.getById(protocolDto.getDocumentTypeId())
                                        , documentHeaderService.getAllByDocumentTypeId(protocolDto.getDocumentTypeId())
                                        , conclusionService.getByDocumentTypeId(protocolDto.getDocumentTypeId())));
       addProtocolTemplate(template, protocolDto);
       return mapper.mapToShortResponseProtocolTemplateDto(template);
    }

    @Override
    public ShortResponseProtocolTemplateDto update(ProtocolTemplateDto protocolDto) {
        if (repository.existsById(protocolDto.getId())) {
            ProtocolTemplate template = repository.save(mapper.mapToProtocolTemplate(protocolDto
                    , documentTypeService.getById(protocolDto.getDocumentTypeId())
                    , documentHeaderService.getAllByDocumentTypeId(protocolDto.getDocumentTypeId())
                    , conclusionService.getByDocumentTypeId(protocolDto.getDocumentTypeId())));
            addProtocolTemplate(template, protocolDto);
            return mapper.mapToShortResponseProtocolTemplateDto(template);
        }
        throw new NotFoundException(
                String.format("Protocol template by id=%s not found for update", protocolDto.getId())
        );
    }

    @Override
    public ResponseProtocolTemplateDto get(Long id) {
        return mapper.mapToResponseProtocolTemplateDto(repository.findById(id).orElseThrow(() -> new NotFoundException(
                String.format("Protocol template by id=%s not found", id))));
    }

    @Override
    public List<ShortResponseProtocolTemplateDto> getAll() {
        return repository.findAll()
                         .stream()
                         .map(mapper::mapToShortResponseProtocolTemplateDto)
                         .toList();
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("Protocol template with id=%s not found for delete", id));
    }

    private void addProtocolTemplate(ProtocolTemplate template, ProtocolTemplateDto protocolDto) {
        subsectionService.addProtocolTemplate(template, protocolDto.getSubsectionTemplatesId());
        tableService.addProtocolTemplate(template, protocolDto.getTableTemplatesId());
    }
}