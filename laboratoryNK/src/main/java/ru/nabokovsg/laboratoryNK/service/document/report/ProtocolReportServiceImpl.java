package ru.nabokovsg.laboratoryNK.service.document.report;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.mapper.document.report.ProtocolReportMapper;
import ru.nabokovsg.laboratoryNK.model.document.report.Section;
import ru.nabokovsg.laboratoryNK.model.laboratoryEmployee.LaboratoryEmployee;
import ru.nabokovsg.laboratoryNK.model.template.report.ProtocolReportTemplate;
import ru.nabokovsg.laboratoryNK.repository.document.report.ProtocolReportRepository;
import ru.nabokovsg.laboratoryNK.service.document.ConclusionService;
import ru.nabokovsg.laboratoryNK.service.document.SubsectionService;
import ru.nabokovsg.laboratoryNK.service.document.TableService;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProtocolReportServiceImpl implements ProtocolReportService {

    private final ProtocolReportRepository repository;
    private final ProtocolReportMapper mapper;
    private final ConclusionService conclusionService;
    private final TableService tableService;
    private final SubsectionService subsectionService;

    @Override
    public void save(Section section, Set<LaboratoryEmployee> employees
                                    , Set<ProtocolReportTemplate> protocolReportTemplates) {
        Map<Integer, ProtocolReportTemplate> templates = protocolReportTemplates.stream()
                                        .collect(Collectors.toMap(ProtocolReportTemplate::getSequentialNumber, t -> t));
        repository.saveAll(protocolReportTemplates.stream()
                .map(t -> mapper.mapToProtocolReport(t, section
                                                      , conclusionService.save(templates.get(t.getSequentialNumber())
                                                                                        .getConclusionTemplate())))
                .toList())
                .forEach(protocol -> {
                    ProtocolReportTemplate template = templates.get(protocol.getSequentialNumber());
                    if (template.getSectionTemplate() != null) {
                        subsectionService.saveFoProtocolReport(protocol, employees, template.getSubsectionTemplates());
                    }
                    if (template.getTableTemplates() != null) {
                        tableService.savaForProtocolReport(protocol, template.getTableTemplates());
                    }
                });
    }
}