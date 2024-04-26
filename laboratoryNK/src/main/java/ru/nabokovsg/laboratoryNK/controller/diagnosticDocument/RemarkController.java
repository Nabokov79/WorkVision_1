package ru.nabokovsg.laboratoryNK.controller.diagnosticDocument;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.laboratoryNK.dto.remark.RemarkDto;
import ru.nabokovsg.laboratoryNK.dto.remark.ResponseRemarkDto;
import ru.nabokovsg.laboratoryNK.service.diagnosticDocument.RemarkService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/laboratory/document/remark",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name="Замечания к документам по результатам обследования",
        description="API для работы с данными замечаний к выполненным документам")
public class RemarkController {

    private final RemarkService service;

    @Operation(summary = "Добавление данных нового замечания к документу или чертежу")
    @PostMapping
    public ResponseEntity<ResponseRemarkDto> save(
            @RequestBody @Parameter(description = "Замечание") RemarkDto remarkDto) {
        return ResponseEntity.ok().body(service.save(remarkDto));
    }

    @Operation(summary = "Изменение данных замечания к документу или чертежу")
    @PatchMapping
    public ResponseEntity<ResponseRemarkDto> update(
            @RequestBody @Parameter(description = "Замечание") RemarkDto remarkDto) {
        return ResponseEntity.ok().body(service.update(remarkDto));
    }

    @Operation(summary = "Получение замечаний к документу и чертежу")
    @GetMapping("/all/{id}")
    public ResponseEntity<List<ResponseRemarkDto>> getAll(
                                 @PathVariable
                                 @Parameter(description = "Индентификатор сотрудника") Long id,
                                 @RequestParam(name = "inspector") Boolean inspector) {
        return ResponseEntity.ok().body(service.getAll(id, inspector));
    }
}