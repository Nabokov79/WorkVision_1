package ru.nabokovsg.laboratoryNK.mapper.diagnosticDocument;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.dto.diagnosticDocument.DiagnosticDocumentDto;
import ru.nabokovsg.laboratoryNK.dto.surveyJournal.ResponseSurveyJournalDto;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocument.DiagnosticDocument;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocument.DiagnosticDocumentType;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocument.DocumentStatus;

@Mapper(componentModel = "spring")
public interface DiagnosticDocumentMapper {

    @Mapping(source = "journal.id", target = "taskJournalId")
    @Mapping(source = "journal.equipmentDiagnosed", target = "equipmentDiagnosed")
    @Mapping(source = "equipmentId", target = "equipmentDiagnosedId")
    @Mapping(source = "documentType", target = "documentType")
    @Mapping(source = "journal.building", target = "installationLocation")
    @Mapping(source = "diagnosticDocumentType", target = "diagnosticDocumentType")
    @Mapping(source = "journal.date", target = "date")
    @Mapping(source = "documentNumber", target = "documentNumber")
    @Mapping(source = "status", target = "status")
    @Mapping(target = "id", ignore = true)
    DiagnosticDocument mapToDiagnosticDocument(ResponseSurveyJournalDto journal
                                             , Long equipmentId
                                             , DiagnosticDocumentType diagnosticDocumentType
                                             , String documentType
                                             , DocumentStatus status
                                             , Integer documentNumber);

    @Mapping(source = "document.taskJournalId", target = "taskJournalId")
    @Mapping(source = "journal.equipmentDiagnosed", target = "equipmentDiagnosed")
    @Mapping(source = "equipmentId", target = "equipmentDiagnosedId")
    @Mapping(source = "documentType", target = "documentType")
    @Mapping(source = "diagnosticDocumentType", target = "diagnosticDocumentType")
    @Mapping(source = "journal.date", target = "date")
    @Mapping(source = "journal.building", target = "installationLocation")
    @Mapping(source = "document.documentNumber", target = "documentNumber")
    @Mapping(source = "document.status", target = "status")
    @Mapping(target = "id", ignore = true)
    DiagnosticDocument mapToUpdateDiagnosticDocument(DiagnosticDocument document
                                                   , ResponseSurveyJournalDto journal
                                                   , Long equipmentId
                                                   , DiagnosticDocumentType diagnosticDocumentType
                                                   , String documentType);

    DiagnosticDocumentDto mapToDiagnosticDocumentDto(DiagnosticDocument document);
}