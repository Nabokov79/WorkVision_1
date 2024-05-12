package ru.nabokovsg.laboratoryNK.service.document.report;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.mapper.document.report.ReportMapper;
import ru.nabokovsg.laboratoryNK.model.common.SurveyJournal;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocuments.DiagnosticDocument;
import ru.nabokovsg.laboratoryNK.model.document.report.Report;
import ru.nabokovsg.laboratoryNK.model.template.report.ReportTemplate;
import ru.nabokovsg.laboratoryNK.repository.document.report.ReportRepository;
import ru.nabokovsg.laboratoryNK.service.document.AppendicesService;
import ru.nabokovsg.laboratoryNK.service.template.report.ReportTemplateService;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository repository;
    private final ReportMapper mapper;
    private final ReportTemplateService reportTemplateService;
    private final PageTitleService pageTitleService;
    private final SectionService sectionService;
    private final AppendicesService appendicesService;


    @Override
    public void save(SurveyJournal surveyJournal, DiagnosticDocument document) {
        ReportTemplate template = reportTemplateService.getByDocumentTypeIdAndEquipmentTypeId(
                                                                            document.getDiagnosticDocumentType().getId()
                                                                          , document.getEquipmentDiagnosedId());
        Report report = repository.save(mapper.mapToReport(document.getSurveyJournalId()
                                                         , document.getEquipmentDiagnosedId()
                                                         , pageTitleService.save(document
                                                                               , surveyJournal.getBuilding()
                                                                               , surveyJournal.getChief()
                                                                               , template.getPageTitleTemplate())));
       sectionService.save(report, template, surveyJournal.getEmployees());
       appendicesService.saveForReport(report, template.getAppendices());
    }
}