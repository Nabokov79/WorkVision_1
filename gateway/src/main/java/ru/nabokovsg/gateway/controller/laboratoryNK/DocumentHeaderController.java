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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.nabokovsg.gateway.client.laboratoryNK.DocumentHeaderClient;
import ru.nabokovsg.gateway.dto.laboratoryNK.documentHeader.NewDocumentHeaderDto;
import ru.nabokovsg.gateway.dto.laboratoryNK.documentHeader.UpdateDocumentHeaderDto;

@RestController
@RequestMapping(
        value = "/WorkVisionWeb/document/header",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Заголовк документа",
        description="API для работы с данными заголовка протоколов и титульных листов отчетов")
public class DocumentHeaderController {

    private final DocumentHeaderClient client;

    @Operation(summary = "Добавление нового заголовка")
    @PostMapping
    public Mono<Object> save(@RequestBody @Valid
                             @Parameter(description = "Данные формирования заголовка") NewDocumentHeaderDto headerDto) {
        return client.save(headerDto);
    }

    @Operation(summary = "Изменение информации в заголовка")
    @PatchMapping
    public Mono<Object> update(@RequestBody @Valid
                          @Parameter(description = "Данные формирования заголовка") UpdateDocumentHeaderDto headerDto) {
        return client.update(headerDto);
    }

    @Operation(summary = "Получить заголовки документа")
    @GetMapping("/{id}")
    public Flux<Object> getAll(@PathVariable @NotNull @Positive
                                   @Parameter(name = "Индентификатор типа документа") Long id) {
        return client.getAll(id);
    }

    @Operation(summary = "Удалить заголовок")
    @DeleteMapping("/{id}")
    public Mono<String> delete(@PathVariable @NotNull @Positive @Parameter(name = "Индентификатор") Long id) {
        return client.delete(id);
    }
}