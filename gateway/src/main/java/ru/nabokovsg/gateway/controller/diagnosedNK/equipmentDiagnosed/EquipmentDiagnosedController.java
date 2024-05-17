package ru.nabokovsg.gateway.controller.diagnosedNK.equipmentDiagnosed;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.nabokovsg.gateway.client.diagnosedNK.equipmentDiagnosed.EquipmentDiagnosedClient;
import ru.nabokovsg.gateway.dto.diagnosedNK.equipmentDiagnosed.equipments.NewEquipmentDto;
import ru.nabokovsg.gateway.dto.diagnosedNK.equipmentDiagnosed.equipments.UpdateEquipmentDto;

@RestController
@RequestMapping(
        value = "/WorkVisionWeb/diagnosed/equipments",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Оборудование",
        description="API для работы с данными оборудования котельных, ЦТП")
public class EquipmentDiagnosedController {

    private final EquipmentDiagnosedClient client;

    @Operation(summary = "Добавление данных оборудования")
    @PostMapping
    public Mono<Object> save(@RequestBody @Valid @Parameter(description = "Оборудование")
                                                          NewEquipmentDto equipmentDto) {
        return client.save(equipmentDto);
    }

    @Operation(summary = "Изменение данных оборудования")
    @PatchMapping
    public Mono<Object> update(@RequestBody @Valid @Parameter(description = "Оборудование")
                                                         UpdateEquipmentDto equipmentDto) {
        return client.update(equipmentDto);
    }

    @Operation(summary = "Получить оборудование")
    @GetMapping("/{id}")
    public Mono<Object> get(@PathVariable @NotNull @Positive @Parameter(description = "Индентификатор") Long id) {
        return client.get(id);
    }

    @Operation(summary = "Получить все оборудование котельной, ЦТП")
    @GetMapping("/all/{id}")
    public Flux<Object> getAll(@PathVariable @NotNull @Positive
                                             @Parameter(description = "Индентификатор котельной, ЦТП") Long id) {
        return client.getAll(id);
    }

    @Operation(summary = "Удаление оборудования")
    @DeleteMapping("/{id}")
    public Mono<String> delete(@PathVariable @NotNull @Positive
                                                       @Parameter(description = "Индентификатор") Long id) {
        return client.delete(id);
    }
}