package ru.nabokovsg.diagnosedNK.controller.common;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.diagnosedNK.dto.common.equipmentRepair.EquipmentRepairDto;
import ru.nabokovsg.diagnosedNK.dto.common.equipmentRepair.ResponseEquipmentRepairDto;
import ru.nabokovsg.diagnosedNK.service.common.EquipmentRepairService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/equipment/repair",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name="Данные выполненного ремонта диагностируемого оборудования",
        description="API для работы с данными ремонта диагностируемого оборудования")
public class EquipmentRepairController {

    private final EquipmentRepairService service;

    @Operation(summary = "Добавить данные выполненного ремонта оборудования")
    @PostMapping
    public ResponseEntity<ResponseEquipmentRepairDto> save(@RequestBody
                                                           @Parameter(name = "Выполненный ремонт")
                                                           EquipmentRepairDto repairDto) {
        return ResponseEntity.ok().body(service.save(repairDto));
    }

    @Operation(summary = "Изменить данные выполненного ремонта оборудования")
    @PatchMapping
    public ResponseEntity<ResponseEquipmentRepairDto> update(@RequestBody
                                                             @Parameter(name = "Выполненный ремонт")
                                                             EquipmentRepairDto repairDto) {
        return ResponseEntity.ok().body(service.update(repairDto));
    }

    @Operation(summary = "Получить данные всех выполненныхо ремонтов оборудования")
    @GetMapping("/all/{id}")
    public ResponseEntity<List<ResponseEquipmentRepairDto>> getAll(
            @PathVariable @Parameter(name = "Индентификатор диагностируемого оборудования") Long id) {
        return ResponseEntity.ok().body(service.getAll(id));
    }

    @Operation(summary = "Удалить данные ремонта оборудования")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(name = "Индентификатор") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Данные ремонта успешно удалены.");
    }
}