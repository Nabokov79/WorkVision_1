package ru.nabokovsg.measurementNK.service.norms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.nabokovsg.measurementNK.dto.norms.acceptableHardness.AcceptableHardnessDto;
import ru.nabokovsg.measurementNK.dto.norms.acceptableHardness.ResponseAcceptableHardnessDto;
import ru.nabokovsg.measurementNK.mapper.norms.AcceptableHardnessMapper;
import ru.nabokovsg.measurementNK.repository.norms.AcceptableHardnessRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AcceptableHardnessServiceImpl implements AcceptableHardnessService {

    private final AcceptableHardnessRepository repository;
    private final AcceptableHardnessMapper mapper;

    @Override
    public ResponseAcceptableHardnessDto save(AcceptableHardnessDto hardnessDto) {
        return mapper.mapToResponseAcceptableHardnessDto(
                Objects.requireNonNullElseGet(repository.findByEquipmentTypeIdAndElementId(hardnessDto.getEquipmentTypeId(), hardnessDto.getElementId())
                        , () -> repository.save(mapper.mapToAcceptableHardness(hardnessDto))));
    }

    @Override
    public ResponseAcceptableHardnessDto update(AcceptableHardnessDto hardnessDto) {
        if (repository.existsById(hardnessDto.getId())) {
            return mapper.mapToResponseAcceptableHardnessDto(
                    repository.save(mapper.mapToAcceptableHardness(hardnessDto))
            );
        }
        throw new NotFoundException(
                String.format("AcceptableHardness with id=%s not found for update", hardnessDto.getId())
        );
    }

    @Override
    public List<ResponseAcceptableHardnessDto> getAll(Long id) {
        return repository.findAllByEquipmentTypeId(id)
                .stream()
                .map(mapper::mapToResponseAcceptableHardnessDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("AcceptableHardness with id=%s not found for delete", id));
    }
}