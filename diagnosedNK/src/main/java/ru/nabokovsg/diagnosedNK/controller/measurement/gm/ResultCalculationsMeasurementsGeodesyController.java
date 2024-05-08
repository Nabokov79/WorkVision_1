package ru.nabokovsg.diagnosedNK.controller.measurement.gm;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nabokovsg.diagnosedNK.dto.measurement.referencePoint.ReferencePointDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.сontrolPoint.ResultControlPoint;
import ru.nabokovsg.diagnosedNK.service.measurement.gm.ResultCalculationsMeasurementsGeodesyService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/measurement/result/geodesic",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name="Расчитанные результаты геодезических измерений",
        description="API для работы с расчитанными результатами геодезических измерений")
public class ResultCalculationsMeasurementsGeodesyController {

    private final ResultCalculationsMeasurementsGeodesyService service;

    @Operation(summary = "Получить рассчитанные данные геодезических измерений реперов оборудования")
    @GetMapping("/reference-point")
    public ResponseEntity<List<ReferencePointDto>> getResultCReferencePoint(
            @RequestParam @Parameter(name = "Индентификатор оборудования") Long equipmentId
    , @RequestParam @Parameter(name = "Индентификатор записи в журнале обследований") Long surveyJournalId) {
        return ResponseEntity.ok().body(service.getResultReferencePoint(equipmentId, surveyJournalId));
    }

    @Operation(summary = "Получить рассчитанные данные геодезических измерений контрольных точек")
    @GetMapping("/control-point")
    public ResponseEntity<ResultControlPoint> getResultControlPoint(
            @RequestParam @Parameter(name = "Индентификатор оборудования") Long equipmentId
            , @RequestParam @Parameter(name = "Индентификатор записи в журнале обследований") Long surveyJournalId) {
        return ResponseEntity.ok().body(service.getResultControlPoint(equipmentId, surveyJournalId));
    }
}