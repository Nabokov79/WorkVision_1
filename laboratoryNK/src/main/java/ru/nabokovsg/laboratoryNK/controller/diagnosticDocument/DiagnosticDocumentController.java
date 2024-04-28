package ru.nabokovsg.laboratoryNK.controller.diagnosticDocument;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.laboratoryNK.dto.diagnosticDocument.DiagnosticDocumentDto;
import ru.nabokovsg.laboratoryNK.service.diagnosticDocument.DiagnosticDocumentService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(
        value = "/laboratory/document",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name="Документы лаборатории НК по результатам обследования",
        description="API для работы с оокументами лаборатории НК по результатам обследования")
public class DiagnosticDocumentController {

    private final DiagnosticDocumentService service;

    @Operation(summary = "Получение данных задачи на выполнение работы")
    @GetMapping("/all")
    public ResponseEntity<List<DiagnosticDocumentDto>> getAll(
                                                  @RequestParam(value = "startPeriod", required = false)
                                                  @Parameter(description = "Начало периода") LocalDate startPeriod
                                                , @RequestParam(value = "endPeriod", required = false)
                                                  @Parameter(description = "Окончание периода") LocalDate endPeriod
                                                , @RequestParam(value = "endPeriod")
                                                  @Parameter(description = "Получить за неделю") boolean week
                                                , @RequestParam(value = "endPeriod")
                                                  @Parameter(description = "Получить за месяц") boolean month) {
        return ResponseEntity.ok().body(service.getAll(startPeriod, endPeriod, week, month));
    }
}