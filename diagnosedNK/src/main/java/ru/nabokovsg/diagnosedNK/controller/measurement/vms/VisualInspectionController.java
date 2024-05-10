package ru.nabokovsg.diagnosedNK.controller.measurement.vms;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.visualInspection.ResponseVisualInspectionDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.visualInspection.VisualInspectionDto;
import ru.nabokovsg.diagnosedNK.service.measurement.vms.VisualInspectionService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/measurement/visual/inspection",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name="Данные визуального осмотра элементов оборудования",
        description="API для работы с данными визуального осмотра элементов оборудования")
public class VisualInspectionController {

    private final VisualInspectionService service;

    @Operation(summary = "Добавить данные визуального осмотра")
    @PostMapping
    public ResponseEntity<ResponseVisualInspectionDto> save(@RequestBody
                                                            @Parameter(name = "Данные визуального осмотра")
                                                            VisualInspectionDto inspectionDto) {
        return ResponseEntity.ok().body(service.save(inspectionDto));
    }

    @Operation(summary = "Измененить данные визуального осмотра")
    @PatchMapping
    public ResponseEntity<ResponseVisualInspectionDto> update(@RequestBody
                                                              @Parameter(name = "Данные визуального осмотра")
                                                              VisualInspectionDto inspectionDto) {
        return ResponseEntity.ok().body(service.update(inspectionDto));
    }

    @Operation(summary = "Получить данные визуального осмотра элементов оборудования")
    @GetMapping("/{id}")
    public ResponseEntity<List<ResponseVisualInspectionDto>> getAll(
            @PathVariable @Parameter(name = "Индентификатор записи в журнале задач") Long id) {
        return ResponseEntity.ok().body(service.getAll(id));
    }

    @Operation(summary = "Удалить данные визуального осмотра")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Parameter(name = "Индентификатор") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Данные визуального осмотра успешно удалены.");
    }
}