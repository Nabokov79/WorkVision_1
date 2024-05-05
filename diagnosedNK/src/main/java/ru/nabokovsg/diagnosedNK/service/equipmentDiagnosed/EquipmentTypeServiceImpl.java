package ru.nabokovsg.diagnosedNK.service.equipmentDiagnosed;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.equipmentType.EquipmentTypeDto;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.equipmentType.ResponseEquipmentTypeDto;
import ru.nabokovsg.diagnosedNK.exceptions.NotFoundException;
import ru.nabokovsg.diagnosedNK.mapper.equipmentDiagnosed.EquipmentTypeMapper;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.EquipmentType;
import ru.nabokovsg.diagnosedNK.repository.equipmentDiagnosed.EquipmentTypeRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EquipmentTypeServiceImpl implements EquipmentTypeService {

    private final EquipmentTypeRepository repository;
    private final EquipmentTypeMapper mapper;

    @Override
    public ResponseEquipmentTypeDto save(EquipmentTypeDto elementTypeDto) {
        return mapper.mapResponseEquipmentTypeDto(
                Objects.requireNonNullElseGet(repository.findByEquipmentNameAndModel(elementTypeDto.getEquipmentName()
                                                                                   , elementTypeDto.getModel()),
                                            () -> repository.save(mapper.mapToEquipmentType(elementTypeDto))));
    }

    @Override
    public ResponseEquipmentTypeDto update(EquipmentTypeDto elementTypeDto) {
        if (repository.existsById(elementTypeDto.getId())) {
            return mapper.mapResponseEquipmentTypeDto(repository.save(mapper.mapToEquipmentType(elementTypeDto)));
        }
        throw new NotFoundException(
                String.format("Equipment type with id=%s not found for update", elementTypeDto.getId()));
    }

    @Override
    public ResponseEquipmentTypeDto get(Long id) {
        return mapper.mapResponseEquipmentTypeDto(getById(id));
    }

    @Override
    public List<ResponseEquipmentTypeDto> getAll() {
        return repository.findAll()
                         .stream()
                         .map(mapper::mapResponseEquipmentTypeDto)
                         .toList();
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("Equipment type with id=%s not found for delete", id));
    }

    @Override
    public EquipmentType getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Equipment type with id=%s not found for delete", id)));
    }
}