package ru.nabokovsg.gateway.controller.laboratoryNK.laboratoryEmployee;

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
import ru.nabokovsg.gateway.client.laboratoryNK.laboratoryEmployee.EmployeeCertificateClient;
import ru.nabokovsg.gateway.dto.laboratoryNK.laboratoryEmployee.NewEmployeeCertificateDto;
import ru.nabokovsg.gateway.dto.laboratoryNK.laboratoryEmployee.UpdateEmployeeCertificateDto;

@RestController
@RequestMapping(
        value = "/WorkVisionWeb/laboratory/nk/employee/certificates",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(name="Аттестация сотрудника",
     description="API для работы с данными аттестации сотрудников лаборатории НК")
public class EmployeeCertificateController {

    private final EmployeeCertificateClient client;

    @Operation(summary = "Добавление данных сертификатов сотрудника")
    @PostMapping
    public Mono<Object> save(@RequestBody @Valid @Parameter(description = "Данные аттестации")
                                                                            NewEmployeeCertificateDto certificateDto) {
        return client.save(certificateDto);
    }

    @Operation(summary = "Изменение данных аттестации сотрудника")
    @PatchMapping
    public Mono<Object> update(@RequestBody @Valid @Parameter(description = "Данные аттестации")
                                                                        UpdateEmployeeCertificateDto certificateDto) {
        return client.update(certificateDto);
    }

    @Operation(summary = "Получение данных аттестации сотрудника")
    @GetMapping("/all/{id}")
    public Flux<Object> getAll(@PathVariable @NotNull @Positive
                                   @Parameter(description = "Индентификатор сотрудника") Long id) {
        return client.getAll(id);
    }

    @Operation(summary = "Удаление данных аттестации сотрудника")
    @DeleteMapping("/{id}")
    public Mono<String> delete(@PathVariable @NotNull @Positive @Parameter(description = "Индентификатор") Long id) {
        return client.delete(id);
    }
}