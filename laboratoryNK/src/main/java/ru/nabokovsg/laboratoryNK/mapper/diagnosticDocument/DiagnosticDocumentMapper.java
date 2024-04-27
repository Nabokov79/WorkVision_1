package ru.nabokovsg.laboratoryNK.mapper.diagnosticDocument;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.dto.diagnosticDocument.DiagnosticDocumentDto;
import ru.nabokovsg.laboratoryNK.dto.surveyJournal.ResponseSurveyJournalDto;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocument.DiagnosticDocument;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocument.DiagnosticDocumentType;

@Mapper(componentModel = "spring")
public interface DiagnosticDocumentMapper {

    @Mapping(source = "journal.id", target = "taskJournalId")
    @Mapping(source = "journal.equipmentDiagnosed", target = "equipmentDiagnosed")
    @Mapping(source = "journal.date", target = "date")
    @Mapping(source = "journal.building", target = "installationLocation")
    @Mapping(source = "equipmentId", target = "equipmentDiagnosedId")
    @Mapping(source = "documentType", target = "documentType")
    @Mapping(source = "diagnosticDocumentType", target = "diagnosticDocumentType")
    @Mapping(source = "documentNumber", target = "documentNumber")
    @Mapping(source = "documentStatus", target = "documentStatus")
    @Mapping(source = "drawingStatus", target = "drawingStatus")
    @Mapping(target = "id", ignore = true)
    DiagnosticDocument mapToDiagnosticDocument(ResponseSurveyJournalDto journal
                                             , Long equipmentId
                                             , DiagnosticDocumentType diagnosticDocumentType
                                             , String documentType
                                             , String documentStatus
                                             , String drawingStatus
                                             , Integer documentNumber);

    @Mapping(source = "document.taskJournalId", target = "taskJournalId")
    @Mapping(source = "journal.equipmentDiagnosed", target = "equipmentDiagnosed")
    @Mapping(source = "equipmentId", target = "equipmentDiagnosedId")
    @Mapping(source = "documentType", target = "documentType")
    @Mapping(source = "diagnosticDocumentType", target = "diagnosticDocumentType")
    @Mapping(source = "journal.date", target = "date")
    @Mapping(source = "journal.building", target = "installationLocation")
    @Mapping(source = "document.documentNumber", target = "documentNumber")
    @Mapping(source = "document.documentStatus", target = "documentStatus")
    @Mapping(source = "document.drawingStatus", target = "drawingStatus")
    @Mapping(target = "id", ignore = true)
    DiagnosticDocument mapToUpdateDiagnosticDocument(DiagnosticDocument document
                                                   , ResponseSurveyJournalDto journal
                                                   , Long equipmentId
                                                   , DiagnosticDocumentType diagnosticDocumentType
                                                   , String documentType);

    DiagnosticDocumentDto mapToDiagnosticDocumentDto(DiagnosticDocument document);
}