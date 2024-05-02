package ru.nabokovsg.laboratoryNK.controller.template;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.laboratoryNK.dto.template.table.ResponseTableTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.table.TableTemplateDto;
import ru.nabokovsg.laboratoryNK.service.template.TableTemplateService;

@RestController
@RequestMapping(
        value = "/template/table",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name="Шаблон таблицы",
        description="API для работы с данными шаблона таблицы")
public class TableTemplateController {

    private final TableTemplateService service;

    @Operation(summary = "Добавление нового шаблона таблицы")
    @PostMapping
    public ResponseEntity<ResponseTableTemplateDto> save(@RequestBody
                                         @Parameter(description = "Данные шаблона таблицы") TableTemplateDto tableDto) {
        return ResponseEntity.ok().body(service.save(tableDto));
    }

    @Operation(summary = "Изменение информации в шаблоне таблицы")
    @PatchMapping
    public ResponseEntity<ResponseTableTemplateDto> update(@RequestBody
                                   @Parameter(description = "Данные шаблона таблицы") TableTemplateDto tableDto) {
        return ResponseEntity.ok().body(service.update(tableDto));
    }

    @Operation(summary = "Получить таблицу")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseTableTemplateDto> get(@PathVariable @Parameter(name = "Индентификатор") Long id) {
        return ResponseEntity.ok().body(service.get(id));
    }

    @Operation(summary = "Удалить таблицу")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(name = "Индентификатор") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Таблица успешно удалена.");
    }
}