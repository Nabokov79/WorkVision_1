package ru.nabokovsg.laboratoryNK.controller.template;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.laboratoryNK.dto.template.conclusion.ConclusionTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.conclusion.ResponseConclusionTemplateDto;
import ru.nabokovsg.laboratoryNK.service.template.ConclusionTemplateService;

@RestController
@RequestMapping(
        value = "/template/conclusion",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name="Шаблон заключений",
        description="API для работы с данными шаблона заключений к протоколам")
public class ConclusionTemplateController {

    private final ConclusionTemplateService service;

    @Operation(summary = "Данные шаблона новых заключений протокола")
    @PostMapping
    public ResponseEntity<ResponseConclusionTemplateDto> save(
            @RequestBody @Parameter(name = "Шаблон заключений") ConclusionTemplateDto conclusionDto) {
        return ResponseEntity.ok().body(service.save(conclusionDto));
    }

    @Operation(summary = "Изменение данных шаблона заключений")
    @PatchMapping
    public ResponseEntity<ResponseConclusionTemplateDto> update(
            @RequestBody @Parameter(name = "Шаблон заключений") ConclusionTemplateDto conclusionDto) {
        return ResponseEntity.ok().body(service.update(conclusionDto));
    }

    @Operation(summary = "Получить шаблон заключения")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseConclusionTemplateDto> get(
            @PathVariable @Parameter(description = "Индентификатор") Long id) {
        return ResponseEntity.ok().body(service.get(id));
    }

    @Operation(summary = "Удалить шаблон заключений")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(name = "Индентификатор") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Шаблоны заключений успешно удалены.");
    }
}