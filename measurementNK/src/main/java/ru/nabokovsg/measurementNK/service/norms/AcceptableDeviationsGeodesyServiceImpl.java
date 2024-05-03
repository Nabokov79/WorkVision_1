package ru.nabokovsg.measurementNK.service.norms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.nabokovsg.measurementNK.dto.norms.geodesy.AcceptableDeviationsGeodesyDto;
import ru.nabokovsg.measurementNK.dto.norms.geodesy.ResponseAcceptableDeviationsGeodesyDto;
import ru.nabokovsg.measurementNK.mapper.norms.AcceptableDeviationsGeodesyMapper;
import ru.nabokovsg.measurementNK.repository.norms.AcceptableDeviationsGeodesyRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AcceptableDeviationsGeodesyServiceImpl implements AcceptableDeviationsGeodesyService {

    private final AcceptableDeviationsGeodesyRepository repository;
    private final AcceptableDeviationsGeodesyMapper mapper;

    @Override
    public ResponseAcceptableDeviationsGeodesyDto save(AcceptableDeviationsGeodesyDto geodesyDto) {
        return mapper.mapToResponseAcceptableDeviationsGeodesyDto(
                Objects.requireNonNullElseGet(
                        repository.findByEquipmentTypeIdAndFullAndOld(geodesyDto.getEquipmentTypeId()
                                , geodesyDto.getFull()
                                , geodesyDto.getOld())
                        , () -> repository.save(mapper.mapToPermissibleDeviationsGeodesy(geodesyDto))));
    }

    @Override
    public ResponseAcceptableDeviationsGeodesyDto update(AcceptableDeviationsGeodesyDto geodesyDto) {
        if (repository.existsById(geodesyDto.getId())) {
            return mapper.mapToResponseAcceptableDeviationsGeodesyDto(
                    repository.save(mapper.mapToPermissibleDeviationsGeodesy(geodesyDto))
            );
        }
        throw new NotFoundException(
                String.format("Acceptable deviations geodesy with id=%s not found for update", geodesyDto.getId())
        );
    }

    @Override
    public List<ResponseAcceptableDeviationsGeodesyDto> getAll(Long id) {
        return repository.findAllByEquipmentTypeId(id)
                         .stream()
                         .map(mapper::mapToResponseAcceptableDeviationsGeodesyDto)
                         .toList();
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("Acceptable deviations geodesy with id=%s not found for delete", id));
    }
}