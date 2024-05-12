package ru.nabokovsg.laboratoryNK.service.document.protocol;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.mapper.document.protocol.SurveyProtocolMapper;
import ru.nabokovsg.laboratoryNK.model.common.SurveyJournal;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocuments.DiagnosticDocument;
import ru.nabokovsg.laboratoryNK.repository.document.protocol.SurveyProtocolRepository;
import ru.nabokovsg.laboratoryNK.service.template.protocol.SurveyProtocolTemplateService;

@Service
@RequiredArgsConstructor
public class SurveyProtocolServiceImpl implements SurveyProtocolService {

    private final SurveyProtocolRepository repository;
    private final SurveyProtocolMapper mapper;

    @Override
    public void save(SurveyJournal surveyJournal, DiagnosticDocument document) {

    }
}