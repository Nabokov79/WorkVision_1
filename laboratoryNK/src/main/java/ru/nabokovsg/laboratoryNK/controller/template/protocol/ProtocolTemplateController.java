package ru.nabokovsg.laboratoryNK.controller.template.protocol;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.laboratoryNK.dto.template.protocol.ProtocolTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.protocol.ResponseProtocolTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.protocol.ShortResponseProtocolTemplateDto;
import ru.nabokovsg.laboratoryNK.service.template.protocol.ProtocolTemplateService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/template/protocol",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name="Шаблон протокола/заключения обследования",
        description="API для работы с данными шаблона протокола/заключения обследования")
public class ProtocolTemplateController {

    private final ProtocolTemplateService service;

    @Operation(summary = "Данные нового шаблона протокола/заключения обследования")
    @PostMapping
    public ResponseEntity<ShortResponseProtocolTemplateDto> save(
            @RequestBody
            @Parameter(description = "Шаблон протокола/заключения обследования") ProtocolTemplateDto protocolDto) {
        return ResponseEntity.ok().body(service.save(protocolDto));
    }

    @Operation(summary = "Данные для изменения информации в шаблоне протокола/заключения обследования")
    @PatchMapping
    public ResponseEntity<ShortResponseProtocolTemplateDto> update(
            @RequestBody
            @Parameter(description = "Шаблон протокола/заключения обследования") ProtocolTemplateDto protocolDto) {
        return ResponseEntity.ok().body(service.update(protocolDto));
    }

    @Operation(summary = "Получить данные шаблона протокола/заключения обследования")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseProtocolTemplateDto> get(@PathVariable @Parameter(name = "Индентификатор") Long id) {
        return ResponseEntity.ok().body(service.get(id));
    }

    @Operation(summary = "Получить краткие данные шаблонов протоколов/заключений обследования")
    @GetMapping("/all")
    public ResponseEntity<List<ShortResponseProtocolTemplateDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление шаблона протокола/заключения обследования")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Шаблон протокола/заключения обследования удалены.");
    }
}