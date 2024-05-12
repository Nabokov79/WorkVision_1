package ru.nabokovsg.laboratoryNK.controller.common;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nabokovsg.laboratoryNK.service.document.DiagnosticDocumentCreateService;

@RestController
@RequestMapping(
        value = "/laboratory/document/create",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name="Документ лаборатории НК по результатам обследования, контроля качества",
        description="API для работы с данными документов результатов выполнения обследования, контроля качества")
public class DiagnosticDocumentCreateController {

    private final DiagnosticDocumentCreateService service;

    @Operation(summary = "Объединение шаблона документа и результатов измерений в документ")
    @GetMapping("/create")
    public ResponseEntity<String> create(
            @RequestParam(value = "surveyJournalId")
            @Parameter(description = "Индентификатор записи журнала обследований") Long surveyJournalId) {
        return ResponseEntity.ok().body(service.create(surveyJournalId));
    }
}