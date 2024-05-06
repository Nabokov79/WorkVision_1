package ru.nabokovsg.gateway.controller.laboratoryNK;

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
import reactor.core.publisher.Mono;
import ru.nabokovsg.gateway.client.laboratoryNK.AppendicesClient;
import ru.nabokovsg.gateway.dto.laboratoryNK.appendices.NewAppendicesDto;
import ru.nabokovsg.gateway.dto.laboratoryNK.appendices.UpdateAppendicesDto;

@RestController
@RequestMapping(
        value = "/WorkVisionWeb/appendices",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@RequiredArgsConstructor
@Tag(name="Приложения документа",
        description="API для работы с данными приложений документа")
public class AppendicesController {

    private final AppendicesClient client;

    @Operation(summary = "Сохранить новое приложение для документа")
    @PostMapping
    public Mono<Object> save(@RequestBody @Valid @Parameter(name = "Приложение") NewAppendicesDto appendicesDto) {
        return client.save(appendicesDto);
    }

    @Operation(summary = "Изменение данных приложения документа")
    @PatchMapping
    public Mono<Object> update(@RequestBody @Valid @Parameter(name = "Приложение") UpdateAppendicesDto appendicesDto) {
        return client.update(appendicesDto);
    }

    @Operation(summary = "Удалить приложение")
    @DeleteMapping("/{id}")
    public Mono<String> delete(@PathVariable @NotNull @Positive @Parameter(name = "Индентификатор") Long id) {
        return client.delete(id);
    }
}