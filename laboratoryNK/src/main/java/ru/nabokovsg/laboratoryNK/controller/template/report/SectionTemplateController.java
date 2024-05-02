package ru.nabokovsg.laboratoryNK.controller.template.report;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.laboratoryNK.dto.template.report.section.ResponseSectionTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.report.section.SectionTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.report.section.ShortResponseSectionTemplateDto;
import ru.nabokovsg.laboratoryNK.service.template.report.SectionTemplateService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/template/section",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name="Шаблон раздела отчета",
        description="API для работы с данными шаблона раздела")
public class SectionTemplateController {

    private final SectionTemplateService service;

    @Operation(summary = "Добавить новые разделы")
    @PostMapping
    public ResponseEntity<ResponseSectionTemplateDto> save(
            @RequestBody @Parameter(description = "Данные шаблона разделов") SectionTemplateDto sectionDto) {
        return ResponseEntity.ok().body(service.save(sectionDto));
    }

    @Operation(summary = "Изменение данных разделов")
    @PatchMapping
    public ResponseEntity<ResponseSectionTemplateDto> update(
            @RequestBody @Parameter(description = "Данные шаблона разделов") SectionTemplateDto sectionDto) {
        return ResponseEntity.ok().body(service.update(sectionDto));
    }

    @Operation(summary = "Получить раздел")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseSectionTemplateDto> get(@PathVariable
                                                          @Parameter(description = "Индентификатор") Long id) {
        return ResponseEntity.ok().body(service.get(id));
    }

    @Operation(summary = "Получить разделы отчета")
    @GetMapping("/all/report/{id}")
    public ResponseEntity<List<ShortResponseSectionTemplateDto>> getAll(
                                             @PathVariable @Parameter(description = "Индентификатор отчета") Long id) {
        return ResponseEntity.ok().body(service.getAll(id));
    }

    @Operation(summary = "Удалить раздел")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Шаблон раздела успешно удален.");
    }
}