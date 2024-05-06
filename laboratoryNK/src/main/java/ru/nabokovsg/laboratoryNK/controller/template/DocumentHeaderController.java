package ru.nabokovsg.laboratoryNK.controller.template;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.laboratoryNK.dto.template.documentHeader.DocumentHeaderDto;
import ru.nabokovsg.laboratoryNK.dto.template.documentHeader.ResponseDocumentHeaderDto;
import ru.nabokovsg.laboratoryNK.service.template.DocumentHeaderService;

import java.util.List;
@RestController
@RequestMapping(
        value = "/template/document/header",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Заголовк документа",
        description="API для работы с данными заголовка протоколов и титульных листов отчетов")
public class DocumentHeaderController {

    private final DocumentHeaderService service;

    @Operation(summary = "Добавление нового заголовка")
    @PostMapping
    public ResponseEntity<ResponseDocumentHeaderDto> save(
            @RequestBody @Parameter(description = "Данные формирования заголовка") DocumentHeaderDto headerDto) {
        return ResponseEntity.ok().body(service.save(headerDto));
    }

    @Operation(summary = "Изменение информации в заголовка")
    @PatchMapping
    public ResponseEntity<ResponseDocumentHeaderDto> update(
            @RequestBody @Parameter(description = "Данные формирования заголовка") DocumentHeaderDto headerDto) {
        return ResponseEntity.ok().body(service.update(headerDto));
    }

    @Operation(summary = "Получить заголовки документа")
    @GetMapping("/{id}")
    public ResponseEntity<List<ResponseDocumentHeaderDto>> getAll(
            @PathVariable @Parameter(name = "Индентификатор типа документа") Long id) {
        return ResponseEntity.ok().body(service.getAll(id));
    }

    @Operation(summary = "Удалить заголовок")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(name = "Индентификатор") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Заголовок успешно удален.");
    }
}