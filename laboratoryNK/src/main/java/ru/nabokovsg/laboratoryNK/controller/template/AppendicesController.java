package ru.nabokovsg.laboratoryNK.controller.template;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.laboratoryNK.dto.template.appendices.AppendicesDto;
import ru.nabokovsg.laboratoryNK.dto.template.appendices.ResponseAppendicesDto;
import ru.nabokovsg.laboratoryNK.service.template.AppendicesService;

@RestController
@RequestMapping(
        value = "/appendices",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name="Приложения документа",
        description="API для работы с данными приложений документа")
public class AppendicesController {

    private final AppendicesService service;

    @Operation(summary = "Сохранить новое приложение для документа")
    @PostMapping
    public ResponseEntity<ResponseAppendicesDto> save(
                                    @RequestBody @Parameter(name = "Приложение") AppendicesDto appendicesDto) {
        return ResponseEntity.ok().body(service.save(appendicesDto));
    }

    @Operation(summary = "Изменение данных приложения документа")
    @PatchMapping
    public ResponseEntity<ResponseAppendicesDto> update(
                                    @RequestBody @Parameter(name = "Приложение") AppendicesDto appendicesDto) {
        return ResponseEntity.ok().body(service.update(appendicesDto));
    }

    @Operation(summary = "Удалить приложение")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(name = "Индентификатор") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Приложение к документу успешно удалено.");
    }
}