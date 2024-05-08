package ru.nabokovsg.diagnosedNK.service.measurement.gm;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.diagnosedNK.dto.measurement.сontrolPoint.ControlPointDto;
import ru.nabokovsg.diagnosedNK.exceptions.NotFoundException;
import ru.nabokovsg.diagnosedNK.mapper.measurement.ControlPointMeasurementMapper;
import ru.nabokovsg.diagnosedNK.model.measurement.gm.ControlPoint;
import ru.nabokovsg.diagnosedNK.model.measurement.gm.GeodesicMeasurement;
import ru.nabokovsg.diagnosedNK.repository.measurement.ControlPointMeasurementRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ControlPointMeasurementServiceImpl implements ControlPointMeasurementService {

    private final ControlPointMeasurementRepository repository;
    private final ControlPointMeasurementMapper mapper;
    private final CalculationGeodesicMeasurementService calculationService;

    @Override
    public Set<ControlPoint> save(List<GeodesicMeasurement> measurements) {
        Integer min = calculationService.getMinMeasurement(measurements.stream()
                .map(GeodesicMeasurement::getControlPointValue)
                .toList());
        return new HashSet<>(repository.saveAll(measurements.stream()
                                                    .map(g -> mapper.mapToControlPoint(
                                                            g
                                                            , calculationService.getDeviation(min
                                                                                           , g.getControlPointValue())))
                                                    .toList()));
    }

    @Override
    public Set<ControlPoint> update(List<GeodesicMeasurement> measurements) {
        Integer min = calculationService.getMinMeasurement(measurements.stream()
                .map(GeodesicMeasurement::getControlPointValue)
                .toList());
        Map<Long, Long> ids = new HashMap<>();
        measurements.forEach(g -> ids.put(g.getSurveyJournalId(), g.getEquipmentId()));
        Long surveyJournalId = ids.keySet().stream().toList().get(0);
        Map<Integer, ControlPoint> points = repository.findAllBySurveyJournalIdAndEquipmentId(surveyJournalId
                                                                                            , ids.get(surveyJournalId))
                                                      .stream()
                                                      .collect(Collectors.toMap(ControlPoint::getPlaceNumber, c -> c));
        return new HashSet<>(repository.saveAll(measurements.stream()
                                                            .map(g -> mapper.mapToUpdateControlPoint(
                                                                    points.get(g.getNumberMeasurementLocation())
                                                                    , g
                                                                    , calculationService.getDeviation(min
                                                                            , g.getControlPointValue())))
                                                            .toList()));
    }

    @Override
    public List<ControlPointDto> getAll(Long equipmentId, Long surveyJournalId) {
        Set<ControlPoint> controlPoints = repository.findAllBySurveyJournalIdAndEquipmentId(surveyJournalId, equipmentId);
        if (controlPoints.isEmpty()) {
            throw new NotFoundException(
                    String.format("ControlPoint by surveyJournalId=%s and equipmentId=%s not found", surveyJournalId
                                                                                                    , equipmentId));
        }
        return controlPoints.stream().map(mapper::mapToControlPointDto).toList();
    }
}