package ru.nabokovsg.laboratoryNK.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.laboratoryNK.dto.tasksJournal.ResponseTasksJournalDto;
import ru.nabokovsg.laboratoryNK.dto.tasksJournal.TasksJournalDto;
import ru.nabokovsg.laboratoryNK.service.TasksJournalService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(
        value = "/journal",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name="Жернал выполненных работ",
        description="API для работы с данными журнала выполненных работ")
public class TasksJournalController {

    private final TasksJournalService service;

    @Operation(summary = "Добавление данных новой задачи на выполнение работы")
    @PostMapping
    public ResponseEntity<ResponseTasksJournalDto> save(
            @RequestBody
            @Parameter(description = "Задача на выполнение работы") TasksJournalDto taskJournalDto) {
        return ResponseEntity.ok().body(service.save(taskJournalDto));
    }

    @Operation(summary = "Изменение данных задачи на выполнение работы")
    @PatchMapping
    public ResponseEntity<ResponseTasksJournalDto> update(
            @RequestBody
            @Parameter(description = "Задача на выполнение работы") TasksJournalDto taskJournalDto) {
        return ResponseEntity.ok().body(service.update(taskJournalDto));
    }

    @Operation(summary = "Получение данных задачи на выполнение работы")
    @GetMapping("/all")
    public ResponseEntity<List<ResponseTasksJournalDto>> getAll(
              @RequestParam(value = "startPeriod", required = false)
              @Parameter(description = "Начало периода для выборки данных") LocalDate startPeriod
            , @RequestParam(value = "endPeriod", required = false)
              @Parameter(description = "Окончание периода для выборки данных") LocalDate endPeriod) {
        return ResponseEntity.ok().body(service.getAll(startPeriod, endPeriod));
    }

    @Operation(summary = "Удаление задачи")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Задача успешно удалена.");
    }
}