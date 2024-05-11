package ru.nabokovsg.laboratoryNK.controller.template;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.laboratoryNK.dto.template.appendices.AppendicesTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.appendices.ResponseAppendicesTemplateDto;
import ru.nabokovsg.laboratoryNK.service.template.AppendicesTemplateService;

@RestController
@RequestMapping(
        value = "/appendices",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name="Приложения документа",
        description="API для работы с данными приложений документа")
public class AppendicesTemplateController {

    private final AppendicesTemplateService service;

    @Operation(summary = "Сохранить новое приложение для документа")
    @PostMapping
    public ResponseEntity<ResponseAppendicesTemplateDto> save(
                                    @RequestBody @Parameter(name = "Приложение") AppendicesTemplateDto appendicesDto) {
        return ResponseEntity.ok().body(service.save(appendicesDto));
    }

    @Operation(summary = "Изменение данных приложения документа")
    @PatchMapping
    public ResponseEntity<ResponseAppendicesTemplateDto> update(
                                    @RequestBody @Parameter(name = "Приложение") AppendicesTemplateDto appendicesDto) {
        return ResponseEntity.ok().body(service.update(appendicesDto));
    }

    @Operation(summary = "Удалить приложение")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(name = "Индентификатор") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Приложение к документу успешно удалено.");
    }
}