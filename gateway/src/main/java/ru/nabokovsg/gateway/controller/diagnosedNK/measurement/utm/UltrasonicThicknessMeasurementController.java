package ru.nabokovsg.gateway.controller.diagnosedNK.measurement.utm;

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
import ru.nabokovsg.gateway.client.diagnosedNK.measurement.UltrasonicThicknessMeasurementClient;
import ru.nabokovsg.gateway.dto.diagnosedNK.measurement.utm.NewUltrasonicThicknessMeasurementDto;
import ru.nabokovsg.gateway.dto.diagnosedNK.measurement.utm.UpdateUltrasonicThicknessMeasurementDto;

@RestController
@RequestMapping(
        value = "/WorkVisionWeb/diagnosed/measurement/ultrasonic-thickness",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Данные ультразвуковой толщинометрии элементов, подэлементов оборудования",
        description="API для работы с данными ультразвуковой толщинометрии элементов, подэлементов оборудования")
public class UltrasonicThicknessMeasurementController {

    private final UltrasonicThicknessMeasurementClient client;

    @Operation(summary = "Добавить ультразвуковой толщинометрии")
    @PostMapping
    public Mono<Object> save(@RequestBody @Valid @Parameter(name = "Данные измерения толщины")
                                        NewUltrasonicThicknessMeasurementDto measurementDto) {
        return client.save(measurementDto);
    }

    @Operation(summary = "Изменить данные ультразвуковой толщинометрии")
    @PatchMapping
    public Mono<Object> update(@RequestBody @Valid @Parameter(name = "Данные измерения толщины")
                                       UpdateUltrasonicThicknessMeasurementDto measurementDto) {
        return client.update(measurementDto);
    }

    @Operation(summary = "Получить данные измеренных дефектов оборудования")
    @GetMapping("/{id}")
    public Flux<Object> getAll(@PathVariable @NotNull @Positive
                                             @Parameter(name = "Индентификатор записи в журнале задач") Long id) {
        return client.getAll(id);
    }

    @Operation(summary = "Удалить измеренный дефект")
    @DeleteMapping("/{id}")
    public Mono<String> delete(@PathVariable @Parameter(name = "Индентификатор") Long id) {
        return client.delete(id);
    }
}