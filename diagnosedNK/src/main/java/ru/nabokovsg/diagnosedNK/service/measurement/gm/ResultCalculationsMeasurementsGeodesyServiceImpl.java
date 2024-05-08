package ru.nabokovsg.diagnosedNK.service.measurement.gm;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.diagnosedNK.dto.measurement.referencePoint.ReferencePointDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.сontrolPoint.ResultControlPoint;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.EquipmentDiagnosed;
import ru.nabokovsg.diagnosedNK.model.measurement.gm.GeodesicMeasurement;
import ru.nabokovsg.diagnosedNK.model.norms.AcceptableDeviationsGeodesy;
import ru.nabokovsg.diagnosedNK.service.equipmentDiagnosed.EquipmentDiagnosedService;
import ru.nabokovsg.diagnosedNK.service.norms.AcceptableDeviationsGeodesyService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultCalculationsMeasurementsGeodesyServiceImpl implements ResultCalculationsMeasurementsGeodesyService {

    private final RecalculateGeodesyMeasurementsService recalculateGeodesyMeasurementsService;
    private final AcceptableDeviationsGeodesyService acceptableDeviationsGeodesyService;
    private final EquipmentDiagnosedService equipmentDiagnosedService;
    private final ControlPointMeasurementService controlPointMeasurementService;
    private final ReferencePointMeasurementService referencePointMeasurementService;
    private final PointDifferenceService pointDifferenceService;

    @Override
    public void save(Long equipmentId, List<GeodesicMeasurement> measurements) {
        AcceptableDeviationsGeodesy acceptableDeviationsGeodesy
                = acceptableDeviationsGeodesyService.getByDataOfEquipmentForCalculations(
                        equipmentDiagnosedService.getById(equipmentId));
        if (measurements.size() == acceptableDeviationsGeodesy.getNumberLocations()) {
            List<GeodesicMeasurement> geodesicMeasurements
                                        = recalculateGeodesyMeasurementsService.recalculateByTransition(measurements);
            referencePointMeasurementService.save(acceptableDeviationsGeodesy, geodesicMeasurements);
           pointDifferenceService.save(acceptableDeviationsGeodesy
                                    , controlPointMeasurementService.save(geodesicMeasurements));
        }
    }

    public void update(Long equipmentId, List<GeodesicMeasurement> measurements) {
        EquipmentDiagnosed equipment = equipmentDiagnosedService.getById(equipmentId);
        AcceptableDeviationsGeodesy acceptableDeviationsGeodesy
                = acceptableDeviationsGeodesyService.getByDataOfEquipmentForCalculations(equipment);
        List<GeodesicMeasurement> geodesicMeasurements
                = recalculateGeodesyMeasurementsService.recalculateByTransition(measurements);
        referencePointMeasurementService.update(acceptableDeviationsGeodesy, geodesicMeasurements);
        pointDifferenceService.update(acceptableDeviationsGeodesy
                                  , controlPointMeasurementService.update(geodesicMeasurements));
    }

    @Override
    public List<ReferencePointDto> getResultReferencePoint(Long equipmentId, Long surveyJournalId) {
        return referencePointMeasurementService.getAll(equipmentId, surveyJournalId);
    }

    @Override
    public ResultControlPoint getResultControlPoint(Long equipmentId, Long surveyJournalId) {
        return new ResultControlPoint(controlPointMeasurementService.getAll(equipmentId, surveyJournalId)
                                    , pointDifferenceService.getAll(equipmentId, surveyJournalId));
    }
}