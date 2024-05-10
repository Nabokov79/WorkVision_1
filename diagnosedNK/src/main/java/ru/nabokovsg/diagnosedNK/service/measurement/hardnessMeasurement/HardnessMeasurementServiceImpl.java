package ru.nabokovsg.diagnosedNK.service.measurement.hardnessMeasurement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.diagnosedNK.dto.measurement.hardnessMeasurement.HardnessMeasurementDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.hardnessMeasurement.ResponseHardnessMeasurementDto;
import ru.nabokovsg.diagnosedNK.exceptions.NotFoundException;
import ru.nabokovsg.diagnosedNK.mapper.measurement.HardnessMeasurementMapper;
import ru.nabokovsg.diagnosedNK.model.measurement.HardnessMeasurement;
import ru.nabokovsg.diagnosedNK.model.norms.AcceptableHardness;
import ru.nabokovsg.diagnosedNK.repository.measurement.HardnessMeasurementRepository;
import ru.nabokovsg.diagnosedNK.service.norms.AcceptableHardnessService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HardnessMeasurementServiceImpl implements HardnessMeasurementService {

    private final HardnessMeasurementRepository repository;
    private final HardnessMeasurementMapper mapper;

    private final AcceptableHardnessService acceptableHardnessService;

    @Override
    public List<ResponseHardnessMeasurementDto> save(HardnessMeasurementDto measurementDto) {
        HardnessMeasurement measurement = mapper.mapToHardnessMeasurement(measurementDto);
        Map<Integer, HardnessMeasurement> measurements
                                   = repository.findAllBySurveyJournalIdAndEquipmentId(measurement.getSurveyJournalId()
                                                                                        , measurement.getEquipmentId())
                                        .stream()
                                        .collect(Collectors.toMap(HardnessMeasurement::getMeasurementNumber, m -> m));
        HardnessMeasurement measurementDb = measurements.get(measurement.getMeasurementNumber());
        if (measurementDb == null) {
            measurements.put(measurement.getMeasurementNumber()
                    , repository.save(mapper.mapHardnessMeasurementWithAcceptableValue(measurement
                                                                                   , getAcceptableValue(measurement))));
        } else {
            measurement = calculateAverageValue(measurement, measurementDb);
            measurements.put(measurementDb.getMeasurementNumber()
                                , mapper.mapHardnessMeasurementWithAcceptableValue(measurement
                                                                                 , getAcceptableValue(measurement)));
        }
        return measurements.values()
                           .stream()
                           .map(mapper::mapToResponseHardnessMeasurementDto)
                           .toList();
    }

    @Override
    public List<ResponseHardnessMeasurementDto> update(HardnessMeasurementDto measurementDto) {
        Map<Integer, HardnessMeasurement> measurements =
                repository.findAllBySurveyJournalIdAndEquipmentId(measurementDto.getSurveyJournalId()
                                                                , measurementDto.getEquipmentId())
                                        .stream()
                                        .collect(Collectors.toMap(HardnessMeasurement::getMeasurementNumber, m -> m));
        HardnessMeasurement measurementDb = measurements.get(measurementDto.getMeasurementNumber());
        if (measurementDb != null) {
            measurements.put(measurementDto.getMeasurementNumber()
                    , repository.save(mapper.mapHardnessMeasurementWithAcceptableValue(measurementDb
                                                                                 , getAcceptableValue(measurementDb))));
        }
        throw new NotFoundException(
                String.format("HardnessMeasurement with MeasurementNumber=%s not found for update"
                                                                             , measurementDto.getMeasurementNumber()));
    }

    @Override
    public List<ResponseHardnessMeasurementDto> getAll(Long id) {
        return repository.findAllBySurveyJournalId(id)
                         .stream()
                         .map(mapper::mapToResponseHardnessMeasurementDto)
                         .toList();
    }

    private boolean getAcceptableValue(HardnessMeasurement measurement) {
        AcceptableHardness acceptableHardness = acceptableHardnessService.getByPredicate(measurement);
        if (acceptableHardness == null) {
            return false;
        } else {
            return measurement.getMeasurementValue() < acceptableHardness.getMinHardness() ||
                    measurement.getMeasurementValue() > acceptableHardness.getMaxHardness();
        }
    }

    private HardnessMeasurement calculateAverageValue(HardnessMeasurement measurement, HardnessMeasurement measurementDb) {
        measurementDb.setMeasurementValue(
                (int) Math.round((double) (measurement.getMeasurementValue() + measurementDb.getMeasurementValue())/2)
        );
        return measurementDb;
    }
}