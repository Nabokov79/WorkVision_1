package ru.nabokovsg.laboratoryNK.service.document.report;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.mapper.document.report.SectionMapper;
import ru.nabokovsg.laboratoryNK.model.document.report.Report;
import ru.nabokovsg.laboratoryNK.model.laboratoryEmployee.LaboratoryEmployee;
import ru.nabokovsg.laboratoryNK.model.template.report.ReportTemplate;
import ru.nabokovsg.laboratoryNK.model.template.report.SectionTemplate;
import ru.nabokovsg.laboratoryNK.repository.document.report.SectionRepository;
import ru.nabokovsg.laboratoryNK.service.document.DocumentEquipmentPassportService;
import ru.nabokovsg.laboratoryNK.service.document.SubsectionService;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService {

    private final SectionRepository repository;
    private final SectionMapper mapper;
    private final ProtocolReportService protocolReportService;
    private final SubsectionService subsectionService;
    private final DocumentEquipmentPassportService passportService;

    @Override
    public void save(Report report, ReportTemplate template, Set<LaboratoryEmployee> employees) {
        Map<Integer, SectionTemplate> sectionsTemplates = template.getSectionsTemplate().stream()
                .collect(Collectors.toMap(SectionTemplate::getSequentialNumber, s -> s));
        repository.saveAll(template.getSectionsTemplate().stream()
                                                  .map(s -> mapper.mapToSection(s, report))
                                                  .toList()).forEach(s -> {
            SectionTemplate sectiontemplate = sectionsTemplates.get(s.getSequentialNumber());
            if (sectiontemplate.getSpecifyEquipmentPassport()) {
                passportService.saveForSection(s, report.getEquipmentDiagnosedId());
            }
            if (!sectiontemplate.getSubsectionTemplates().isEmpty()) {
                subsectionService.saveForSection(s, employees, sectiontemplate.getSubsectionTemplates());
            }
            if (!sectiontemplate.getProtocolReportTemplates().isEmpty()) {
                protocolReportService.save(s, employees, sectiontemplate.getProtocolReportTemplates());
            }
        });
    }
}
