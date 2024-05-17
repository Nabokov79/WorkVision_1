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
import ru.nabokovsg.gateway.client.diagnosedNK.equipmentDiagnosed.EquipmentPassportClient;
import ru.nabokovsg.gateway.dto.diagnosedNK.equipmentDiagnosed.passport.NewEquipmentPassportDto;
import ru.nabokovsg.gateway.dto.diagnosedNK.equipmentDiagnosed.passport.UpdateEquipmentPassportDto;

@RestController
@RequestMapping(
        value = "/WorkVisionWeb/diagnosed/equipments/passport",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Паспорт оборудования",
        description="API для работы с данными паспорта оборудования")
public class EquipmentPassportController {

    private final EquipmentPassportClient client;

    @Operation(summary = "Добавление данных паспорта")
    @PostMapping
    public Mono<Object> save(@RequestBody @Valid @Parameter(description = "Пасспорт")
                                               NewEquipmentPassportDto passportDto) {
        return client.save(passportDto);
    }

    @Operation(summary = "Изменение данных паспорта")
    @PatchMapping
    public Mono<Object> update(@RequestBody @Valid @Parameter(description = "Паспорт")
                                             UpdateEquipmentPassportDto passportDto) {
        return client.update(passportDto);
    }

    @Operation(summary = "Получить данные паспорта оборудования")
    @GetMapping("/all/{id}")
    public Flux<Object> getAll(@PathVariable @NotNull @Positive
                                             @Parameter(description = "Индентификатор оборудования") Long id) {
        return client.getAll(id);
    }

    @Operation(summary = "Удаление данных паспорта")
    @DeleteMapping("/{id}")
    public Mono<String> delete(@PathVariable @NotNull @Positive @Parameter(description = "Индентификатор") Long id) {
        return client.delete(id);
    }
}