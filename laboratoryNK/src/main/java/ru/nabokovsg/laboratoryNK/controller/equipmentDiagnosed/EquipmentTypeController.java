package ru.nabokovsg.laboratoryNK.controller.equipmentDiagnosed;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nabokovsg.laboratoryNK.dto.equipmentDiagnosed.equipmentType.ResponseEquipmentTypeDto;
import ru.nabokovsg.laboratoryNK.service.equipmentDiagnosed.EquipmentTypeService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/equipments/type",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name="Тип оборудования",
        description="API для работы с данными типа оборудования")
public class EquipmentTypeController {

    private final EquipmentTypeService service;

    @Operation(summary = "Получить все типы оборудования")
    @GetMapping("/all")
    public ResponseEntity<List<ResponseEquipmentTypeDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }
}