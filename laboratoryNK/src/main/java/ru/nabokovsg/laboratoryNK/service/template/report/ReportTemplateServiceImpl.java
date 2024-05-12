package ru.nabokovsg.laboratoryNK.service.template.report;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.dto.template.report.ResponseReportTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.report.ShortResponseReportTemplateDto;
import ru.nabokovsg.laboratoryNK.exceptions.NotFoundException;
import ru.nabokovsg.laboratoryNK.mapper.template.report.ReportTemplateMapper;
import ru.nabokovsg.laboratoryNK.model.template.report.PageTitleTemplate;
import ru.nabokovsg.laboratoryNK.model.template.report.ReportTemplate;
import ru.nabokovsg.laboratoryNK.repository.template.report.ReportTemplateRepository;
import ru.nabokovsg.laboratoryNK.service.template.AppendicesTemplateService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportTemplateServiceImpl implements ReportTemplateService {

    private final ReportTemplateRepository repository;
    private final ReportTemplateMapper mapper;
    private final AppendicesTemplateService appendicesTemplateService;

    @Override
    public ResponseReportTemplateDto get(Long id) {
        return mapper.mapToResponseReportTemplateDto(repository.findById(id).orElseThrow(() -> new NotFoundException(
                String.format("ReportTemplate with id=%s not found", id))));
    }

    @Override
    public List<ShortResponseReportTemplateDto> getAll() {
        return repository.findAllPageTitleTemplate().stream().map(mapper::mapToShortResponseReportTemplateDto).toList();
    }

    @Override
    public void save(Long documentTypeId, Long equipmentTypeId, PageTitleTemplate template) {
        appendicesTemplateService.addReportTemplate(repository.save(mapper.mapToReportTemplate(documentTypeId, equipmentTypeId, template)));
    }

    @Override
    public void validateByIds(Long documentTypeId, Long equipmentTypeId) {
        if (repository.existsByDocumentTypeIdAndEquipmentTypeId(documentTypeId, equipmentTypeId)) {
            throw new NotFoundException(
                    String.format("ReportTemplate with documentTypeId=%s equipmentTypeId=%s is found", documentTypeId
                                                                                                 , equipmentTypeId));
        }
    }

    @Override
    public ReportTemplate getByDocumentTypeIdAndEquipmentTypeId(Long documentTypeId, Long equipmentTypeId) {
        return repository.findByDocumentTypeIdAndEquipmentTypeId(documentTypeId, equipmentTypeId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("ReportTemplate by documentTypeId=%s and equipmentTypeId=%s not found"
                                                                                           , documentTypeId
                                                                                           , equipmentTypeId)));
    }
}