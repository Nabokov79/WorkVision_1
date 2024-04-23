package ru.nabokovsg.laboratoryNK.dto.tasksJournal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные для добавления/изменения информации об выполняемой работе")
public class TasksJournalDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Дата обследования")
    private LocalDate date;
    @Schema(description = "Индентификатор филиала организации")
    private Long branchId;
    @Schema(description = "Индентификатор района теплоснабжения")
    private Long heatSupplyAreaId;
    @Schema(description = "Индентификатор эксплуатационного участка")
    private Long exploitationRegionId;
    @Schema(description = "Место проведения работ")
    private Long addressId;
    @Schema(description = "Индентификатор оборудования")
    private String equipmentId;
    @Schema(description = "Тип выполняемой работы")
    private String workType;
    @Schema(description = "Основание проведения работы(адресная программа, заявка, распоряжение руководителя)")
    private String taskSource;
    @Schema(description = "Комментарий к задаче")
    private String comment;
    @Schema(description = "Индентификаторы руководителя работ")
    private Long laboratoryEmployeeId;
    @Schema(description = "Индентификаторы сотрудников лаборатории назначенных для выполнения задачи")
    private List<Long> laboratoryEmployeesIds;
}