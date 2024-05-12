package ru.nabokovsg.laboratoryNK.service.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.mapper.document.SubsectionMapper;
import ru.nabokovsg.laboratoryNK.model.document.Subsection;
import ru.nabokovsg.laboratoryNK.model.document.report.ProtocolReport;
import ru.nabokovsg.laboratoryNK.model.document.report.Section;
import ru.nabokovsg.laboratoryNK.model.laboratoryEmployee.LaboratoryEmployee;
import ru.nabokovsg.laboratoryNK.model.template.SubsectionTemplate;
import ru.nabokovsg.laboratoryNK.repository.document.SubsectionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubsectionServiceImpl implements SubsectionService {

    private final SubsectionRepository repository;
    private final SubsectionMapper mapper;
    private final RegulatoryDocumentationService documentationService;
    private final DocumentMeasuringToolService measuringToolService;
    private final TableService tableService;

    @Override
    public void saveForSection(Section section, Set<LaboratoryEmployee> employees
                                              , Set<SubsectionTemplate> subsectionTemplates) {
        List<Subsection> subsections = new ArrayList<>();
                subsectionTemplates.forEach(s -> {
                    if (s.getTableTemplate() != null) {
                        if (s.getTableTemplate() != null) {
                             subsections.add(mapper.mapWithTable(s, section,
                                                            tableService.savaForSubsection(s.getTableTemplate())));
                        }
                    } else {
                         subsections.add(mapper.mapToSubsection(s, section));
                    }
                });
        common(repository.saveAll(subsections), subsectionTemplates, employees);
    }

    @Override
    public void saveFoProtocolReport(ProtocolReport protocol, Set<LaboratoryEmployee> employees
                                                            , Set<SubsectionTemplate> subsectionTemplates) {
        common(repository.saveAll(subsectionTemplates.stream()
                                                     .map( s -> mapper.mapWithProtocolReport(s, protocol))
                                                     .toList())
                , subsectionTemplates
                , employees);
    }

    private void common(List<Subsection> subsections
                      , Set<SubsectionTemplate> subsectionTemplates
                      , Set<LaboratoryEmployee> employees) {
        Map<Integer, SubsectionTemplate> templates = subsectionTemplates.stream()
                .collect(Collectors.toMap(SubsectionTemplate::getSequentialNumber, s -> s));
        subsections.forEach(subsection -> {
            SubsectionTemplate template = templates.get(subsection.getSequentialNumber());
            if (!template.getDocumentationTemplate().isEmpty()) {
                documentationService.save(subsection, template.getDocumentationTemplate());
            }
            if (!template.getMeasuringToolsTemplates().isEmpty()) {
                measuringToolService.save(subsection, employees,template.getMeasuringToolsTemplates());
            }
        });
    }
}