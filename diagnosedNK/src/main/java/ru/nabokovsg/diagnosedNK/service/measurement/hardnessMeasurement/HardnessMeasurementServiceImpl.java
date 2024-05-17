package ru.nabokovsg.diagnosedNK.service.measurement.hardnessMeasurement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.diagnosedNK.dto.measurement.hardnessMeasurement.HardnessMeasurementDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.hardnessMeasurement.ResponseHardnessMeasurementDto;
import ru.nabokovsg.diagnosedNK.exceptions.NotFoundException;
import ru.nabokovsg.diagnosedNK.mapper.measurement.HardnessMeasurementMapper;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.EquipmentElement;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.PartElement;
import ru.nabokovsg.diagnosedNK.model.measurement.HardnessMeasurement;
import ru.nabokovsg.diagnosedNK.model.norms.AcceptableHardness;
import ru.nabokovsg.diagnosedNK.repository.measurement.HardnessMeasurementRepository;
import ru.nabokovsg.diagnosedNK.service.equipmentDiagnosed.EquipmentElementService;
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
    private final EquipmentElementService equipmentElementService;

    @Override
    public List<ResponseHardnessMeasurementDto> save(HardnessMeasurementDto measurementDto) {
        EquipmentElement element = equipmentElementService.getById(measurementDto.getElementId());
        Map<Long, PartElement> partsElement = element.getPartsElement()
                                              .stream().collect(Collectors.toMap(PartElement::getId, p -> p));
        HardnessMeasurement measurement = mapper.mapWithEquipmentElement(measurementDto, element);
        if(measurementDto.getPartElementId() != null) {
            measurement = mapper.mapWithPartElement(measurement, partsElement.get(measurementDto.getPartElementId()));
        }
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
                String.format("HardnessMeasurement with measurementNumber=%s not found for update"
                                                                             , measurementDto.getMeasurementNumber()));
    }

    @Override
    public List<ResponseHardnessMeasurementDto> getAll(Long id) {
        return repository.findAllBySurveyJournalId(id)
                         .stream()
                         .map(mapper::mapToResponseHardnessMeasurementDto)
                         .toList();
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(
                String.format("HardnessMeasurement with id=%s not found for delete", id));
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