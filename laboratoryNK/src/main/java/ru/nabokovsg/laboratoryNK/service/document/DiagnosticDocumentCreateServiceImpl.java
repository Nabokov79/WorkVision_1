package ru.nabokovsg.laboratoryNK.service.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.model.common.SurveyJournal;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocuments.DiagnosticDocument;
import ru.nabokovsg.laboratoryNK.repository.diagnosticDocuments.DiagnosticDocumentRepository;
import ru.nabokovsg.laboratoryNK.service.common.SurveyJournalService;
import ru.nabokovsg.laboratoryNK.service.document.protocol.ProtocolControlService;
import ru.nabokovsg.laboratoryNK.service.document.protocol.SurveyProtocolService;
import ru.nabokovsg.laboratoryNK.service.document.report.ReportService;

@Service
@RequiredArgsConstructor
public class DiagnosticDocumentCreateServiceImpl implements DiagnosticDocumentCreateService {

    private final DiagnosticDocumentRepository repository;
    private final ReportService reportService;
    private final ProtocolControlService protocolControlService;
    private final SurveyProtocolService surveyProtocolService;
    private final SurveyJournalService surveyJournalService;

    @Override
    public String create(Long surveyJournalId) {
        DiagnosticDocument document = repository.findBySurveyJournalId(surveyJournalId);
        if (document == null) {
            return String.format("DiagnosticDocument for surveyJournalId=%s not found", surveyJournalId);
        }
        SurveyJournal surveyJournal = surveyJournalService.getById(document.getSurveyJournalId());
        switch (document.getDiagnosticDocumentType().getTypeDocument()) {
            case REPORT -> reportService.save(surveyJournal, document);
            case SURVEY_PROTOCOL -> surveyProtocolService.save(surveyJournal, document);
            case CONTROL_PROTOCOL -> protocolControlService.save(surveyJournal, document);
        }
        return String.join(" ", "Создан"
                , document.getDocumentType()
                , "№" , String.valueOf(document.getDocumentNumber())
                , "от", String.valueOf(document.getDate()));
    }
}