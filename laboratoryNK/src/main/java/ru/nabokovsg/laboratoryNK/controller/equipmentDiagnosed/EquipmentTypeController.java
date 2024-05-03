package ru.nabokovsg.laboratoryNK.controller.equipmentDiagnosed;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.laboratoryNK.dto.equipmentDiagnosed.equipmentType.EquipmentTypeDto;
import ru.nabokovsg.laboratoryNK.dto.equipmentDiagnosed.equipmentType.ResponseEquipmentTypeDto;
import ru.nabokovsg.laboratoryNK.service.equipmentDiagnosed.EquipmentTypeService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/equipments/type",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "Тип оборудования",
        description = "API для работы с данными типа оборудования")
public class EquipmentTypeController {

    private final EquipmentTypeService service;

    @Operation(summary = "Добавление нового типа оборудования")
    @PostMapping
    public ResponseEntity<ResponseEquipmentTypeDto> save(
            @RequestBody @Parameter(description = "Тип оборудования") EquipmentTypeDto elementTypeDto) {
        return ResponseEntity.ok().body(service.save(elementTypeDto));
    }

    @Operation(summary = "Изменение данных типа оборудования")
    @PatchMapping
    public ResponseEntity<ResponseEquipmentTypeDto> update(
            @RequestBody @Parameter(description = "Тип оборудования") EquipmentTypeDto elementTypeDto) {
        return ResponseEntity.ok().body(service.update(elementTypeDto));
    }

    @Operation(summary = "Получить тип оборудования")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseEquipmentTypeDto> get(
            @PathVariable @Parameter(description = "Индентификатор") Long id) {
        return ResponseEntity.ok().body(service.get(id));
    }

    @Operation(summary = "Получить все типы оборудования")
    @GetMapping("/all")
    public ResponseEntity<List<ResponseEquipmentTypeDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Удаление типа оборудования")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(description = "Индентификатор") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Тип оборудования успешно удален.");
    }
}