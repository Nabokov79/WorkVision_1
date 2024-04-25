package ru.nabokovsg.laboratoryNK.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.dto.tasksJournal.ResponseTasksJournalDto;
import ru.nabokovsg.laboratoryNK.dto.tasksJournal.TasksJournalDto;
import ru.nabokovsg.laboratoryNK.model.TasksJournal;

@Mapper(componentModel = "spring")
public interface TasksJournalMapper {

    @Mapping(source = "date", target = "date")
    @Mapping(source = "branch", target = "branch")
    @Mapping(source = "heatSupplyArea", target = "heatSupplyArea")
    @Mapping(source = "exploitationRegion", target = "exploitationRegion")
    @Mapping(source = "workPlace", target = "workPlace")
    @Mapping(source = "equipmentDiagnosed", target = "equipmentDiagnosed")
    @Mapping(source = "workType", target = "workType")
    @Mapping(source = "taskSource", target = "taskSource")
    @Mapping(source = "comment", target = "comment")
    @Mapping(source = "taskJournalDto.id", target = "id")
    TasksJournal mapToTaskJournal(TasksJournalDto taskJournalDto
                                , String branch
                                , String heatSupplyArea
                                , String exploitationRegion
                                , String workPlace
                                , String equipmentDiagnosed);

    ResponseTasksJournalDto mapToResponseTaskJournalDto(TasksJournal journal);
}