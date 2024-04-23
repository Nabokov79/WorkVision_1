package ru.nabokovsg.laboratoryNK.service.equipmentDiagnosed;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.model.equipmentDiagnosed.StandardSize;
import ru.nabokovsg.laboratoryNK.dto.equipmentDiagnosed.standardSize.StandardSizeDto;
import ru.nabokovsg.laboratoryNK.exceptions.NotFoundException;
import ru.nabokovsg.laboratoryNK.mapper.equipmentDiagnosed.StandardSizeMapper;
import ru.nabokovsg.laboratoryNK.repository.equipmentDiagnosed.StandardSizeRepository;

@Service
@RequiredArgsConstructor
public class StandardSizeServiceImpl implements StandardSizeService {

    private final StandardSizeRepository repository;
    private final StandardSizeMapper mapper;

    @Override
    public StandardSize save(StandardSizeDto standardSizeDto) {
        return repository.save(mapper.mapToStandardSize(standardSizeDto));
    }

    @Override
    public StandardSize update(StandardSizeDto standardSizeDto) {
        if (repository.existsById(standardSizeDto.getId())) {
            return repository.save(mapper.mapToStandardSize(standardSizeDto));
        }
        throw new NotFoundException(
                String.format("StandardSize with id=%s not found for update", standardSizeDto.getId())
        );
    }
}