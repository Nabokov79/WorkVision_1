package ru.nabokovsg.laboratoryNK.controller.template.report;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.laboratoryNK.dto.template.report.ResponseReportTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.report.ShortResponseReportTemplateDto;
import ru.nabokovsg.laboratoryNK.service.template.report.ReportTemplateService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/template/report",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Шаблон отчета",
        description="API для работы с данными шаблона отчета")
public class ReportTemplateController {

    private final ReportTemplateService service;

    @Operation(summary = "Получить шаблон отчета")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseReportTemplateDto> get(@PathVariable @Parameter(name = "Индентификатор") Long id) {
        return ResponseEntity.ok().body(service.get(id));
    }

    @Operation(summary = "Получить все шаблоны отчетов")
    @GetMapping
    public ResponseEntity<List<ShortResponseReportTemplateDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }
}