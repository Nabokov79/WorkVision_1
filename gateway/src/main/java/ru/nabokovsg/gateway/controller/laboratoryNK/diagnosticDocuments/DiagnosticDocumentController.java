package ru.nabokovsg.gateway.controller.laboratoryNK.diagnosticDocuments;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.nabokovsg.gateway.client.laboratoryNK.diagnosticDocuments.DiagnosticDocumentClient;

import java.time.LocalDate;

@RestController
@RequestMapping(
        value = "/WorkVisionWeb/laboratory/nk/document",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name="Документы лаборатории НК по результатам обследования",
        description="API для работы с оокументами лаборатории НК по результатам обследования")
public class DiagnosticDocumentController {

    private final DiagnosticDocumentClient client;

    @Operation(summary = "Получение данных задачи на выполнение работы")
    @GetMapping("/all")
    public Flux<Object> getAll(@RequestParam(value = "startPeriod", required = false)
                              @Parameter(description = "Начало периода") LocalDate startPeriod
                            , @RequestParam(value = "endPeriod", required = false)
                              @Parameter(description = "Окончание периода") LocalDate endPeriod
                            , @RequestParam(value = "endPeriod")
                              @Parameter(description = "Получить за неделю") boolean week
                            , @RequestParam(value = "endPeriod")
                              @Parameter(description = "Получить за месяц") boolean month) {
        return client.getAll(startPeriod, endPeriod, week, month);
    }
}