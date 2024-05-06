package ru.nabokovsg.gateway.controller.laboratoryNK.report;

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
import ru.nabokovsg.gateway.client.laboratoryNK.report.SectionTemplateClient;
import ru.nabokovsg.gateway.dto.laboratoryNK.report.section.NewSectionWithProtocolTemplateDto;
import ru.nabokovsg.gateway.dto.laboratoryNK.report.section.NewSectionWithSubsectionTemplateDto;
import ru.nabokovsg.gateway.dto.laboratoryNK.report.section.UpdateSectionWithProtocolTemplateDto;
import ru.nabokovsg.gateway.dto.laboratoryNK.report.section.UpdateSectionWithSubsectionTemplateDto;

@RestController
@RequestMapping(
        value = "/WorkVisionWeb/section",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Шаблон раздела отчета",
        description="API для работы с данными шаблона раздела")
public class SectionTemplateController {

    private final SectionTemplateClient client;

    @Operation(summary = "Добавить новые разделы")
    @PostMapping
    public Mono<Object> saveWithSubsection(@RequestBody @Valid @Parameter(description = "Данные шаблона раздела")
                                                                    NewSectionWithSubsectionTemplateDto sectionDto) {
        return client.saveWithSubsection(sectionDto);
    }

    @Operation(summary = "Изменение данных разделов")
    @PatchMapping
    public Mono<Object> updateWithSubsection(@RequestBody @Valid @Parameter(description = "Данные шаблона разделф")
                                                                UpdateSectionWithSubsectionTemplateDto sectionDto) {
        return client.updateWithSubsection(sectionDto);
    }

    @Operation(summary = "Добавить новые разделы")
    @PostMapping
    public Mono<Object> saveWithProtocol(@RequestBody @Valid @Parameter(description = "Данные шаблона раздела")
                                                                    NewSectionWithProtocolTemplateDto sectionDto) {
        return client.saveWithProtocol(sectionDto);
    }

    @Operation(summary = "Изменение данных разделов")
    @PatchMapping
    public Mono<Object> updateWithProtocol( @RequestBody @Valid @Parameter(description = "Данные шаблона разделф")
                                                                    UpdateSectionWithProtocolTemplateDto sectionDto) {
        return client.updateWithProtocol(sectionDto);
    }

    @Operation(summary = "Получить раздел")
    @GetMapping("/{id}")
    public Mono<Object> get(@PathVariable @NotNull @Positive @Parameter(description = "Индентификатор") Long id) {
        return client.get(id);
    }

    @Operation(summary = "Получить разделы отчета")
    @GetMapping("/all/report/{id}")
    public Flux<Object> getAll(@PathVariable @NotNull @Positive
                               @Parameter(description = "Индентификатор шаблона отчета") Long id) {
        return client.getAll(id);
    }

    @Operation(summary = "Удалить раздел")
    @DeleteMapping("/{id}")
    public Mono<String> delete(@PathVariable @Parameter(description = "Индентификатор") Long id) {
        return client.delete(id);
    }
}