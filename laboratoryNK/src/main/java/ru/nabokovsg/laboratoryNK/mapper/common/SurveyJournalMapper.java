package ru.nabokovsg.laboratoryNK.mapper.common;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.dto.common.surveyJournal.ResponseSurveyJournalDto;
import ru.nabokovsg.laboratoryNK.dto.common.surveyJournal.SurveyJournalDto;
import ru.nabokovsg.laboratoryNK.model.common.SurveyJournal;

@Mapper(componentModel = "spring")
public interface SurveyJournalMapper {

    @Mapping(source = "taskJournalDto.date", target = "date")
    @Mapping(source = "branch", target = "branch")
    @Mapping(source = "heatSupplyArea", target = "heatSupplyArea")
    @Mapping(source = "exploitationRegion", target = "exploitationRegion")
    @Mapping(source = "building", target = "building")
    @Mapping(source = "equipmentDiagnosed", target = "equipmentDiagnosed")
    @Mapping(source = "taskJournalDto.workType", target = "workType")
    @Mapping(source = "taskJournalDto.taskSource", target = "taskSource")
    @Mapping(source = "taskJournalDto.comment", target = "comment")
    @Mapping(source = "taskJournalDto.id", target = "id")
    SurveyJournal mapToTaskJournal(SurveyJournalDto taskJournalDto
                                , String branch
                                , String heatSupplyArea
                                , String exploitationRegion
                                , String building
                                , String equipmentDiagnosed);

    ResponseSurveyJournalDto mapToResponseTaskJournalDto(SurveyJournal journal);
}