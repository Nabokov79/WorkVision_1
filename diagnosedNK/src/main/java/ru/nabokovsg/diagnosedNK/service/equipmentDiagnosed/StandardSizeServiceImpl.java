package ru.nabokovsg.diagnosedNK.service.equipmentDiagnosed;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.standardSize.StandardSizeDto;
import ru.nabokovsg.diagnosedNK.exceptions.NotFoundException;
import ru.nabokovsg.diagnosedNK.mapper.equipmentDiagnosed.StandardSizeMapper;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.StandardSize;
import ru.nabokovsg.diagnosedNK.repository.equipmentDiagnosed.StandardSizeRepository;

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