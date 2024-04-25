package ru.nabokovsg.laboratoryNK.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.dto.tasksJournal.ResponseTasksJournalDto;
import ru.nabokovsg.laboratoryNK.dto.tasksJournal.TasksJournalDto;
import ru.nabokovsg.laboratoryNK.model.TasksJournal;

@Mapper(componentModel = "spring")
public interface TasksJournalMapper {

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
    TasksJournal mapToTaskJournal(TasksJournalDto taskJournalDto
                                , String branch
                                , String heatSupplyArea
                                , String exploitationRegion
                                , String building
                                , String equipmentDiagnosed);

    ResponseTasksJournalDto mapToResponseTaskJournalDto(TasksJournal journal);
}