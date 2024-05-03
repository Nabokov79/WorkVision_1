package ru.nabokovsg.measurementNK.service.norms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.measurementNK.mapper.norms.MeasuredParameterMapper;
import ru.nabokovsg.measurementNK.model.norms.Defect;
import ru.nabokovsg.measurementNK.model.norms.ElementRepair;
import ru.nabokovsg.measurementNK.repository.norms.MeasuredParameterRepository;
import ru.nabokovsg.measurementNK.dto.norms.measuredParameter.MeasuredParameterDto;
import ru.nabokovsg.measurementNK.model.norms.MeasuredParameter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MeasuredParameterServiceImpl implements MeasuredParameterService {

    private final MeasuredParameterRepository repository;
    private final MeasuredParameterMapper mapper;
    private final ConstParameterMeasurementService constService;

    @Override
    public Set<MeasuredParameter> saveForDefect(Defect defect, List<MeasuredParameterDto> parametersDto) {
        return new HashSet<>(repository.saveAll(parametersDto.stream()
                .map(p -> mapper.mapForDefect(
                          constService.getMeasuredParameter(p.getMeasuredParameter())
                        , constService.getUnitMeasurement(p.getUnitMeasurement())
                        , defect))
                .toList()));
    }

    @Override
    public Set<MeasuredParameter> saveForElementRepair(ElementRepair repair, List<MeasuredParameterDto> parametersDto) {
        return new HashSet<>(repository.saveAll(
                parametersDto.stream()
                        .map(p -> mapper.mapForElementRepair(
                                  constService.getMeasuredParameter(p.getMeasuredParameter())
                                , constService.getUnitMeasurement(p.getUnitMeasurement())
                                , repair))
                        .toList())
        );
    }

    @Override
    public Set<MeasuredParameter> update(List<MeasuredParameterDto> parametersDto) {
        return new HashSet<>(repository.saveAll(
                parametersDto.stream()
                        .map(p -> mapper. mapToUpdateMeasuredParameter(p.getId()
                                , constService.getMeasuredParameter(p.getMeasuredParameter())
                                , constService.getUnitMeasurement(p.getUnitMeasurement())))
                        .toList())
        );
    }
}