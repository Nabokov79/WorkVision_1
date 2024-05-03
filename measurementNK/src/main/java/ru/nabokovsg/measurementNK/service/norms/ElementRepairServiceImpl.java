package ru.nabokovsg.measurementNK.service.norms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.nabokovsg.measurementNK.dto.norms.elementRepair.ElementRepairDto;
import ru.nabokovsg.measurementNK.dto.norms.elementRepair.ResponseElementRepairDto;
import ru.nabokovsg.measurementNK.dto.norms.elementRepair.ResponseShortElementRepairDto;
import ru.nabokovsg.measurementNK.exceptions.BadRequestException;
import ru.nabokovsg.measurementNK.mapper.norms.ElementRepairMapper;
import ru.nabokovsg.measurementNK.model.norms.ActionsOnParameter;
import ru.nabokovsg.measurementNK.model.norms.ElementRepair;
import ru.nabokovsg.measurementNK.repository.norms.ElementRepairRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElementRepairServiceImpl implements ElementRepairService {

    private final ElementRepairRepository repository;
    private final ElementRepairMapper mapper;
    private final MeasuredParameterService parameterService;


    @Override
    public ResponseElementRepairDto save(ElementRepairDto repairDto) {
        ElementRepair repair = repository.findByRepairName(repairDto.getRepairName());
        if (repair == null) {
            repair = repository.save(mapper.mapToElementRepair(repairDto
                                                        , getActionsOnParameter(repairDto.getActionsOnParameter())));
            repair.setMeasuredParameters(
                                    parameterService.saveForElementRepair(repair, repairDto.getMeasuredParameters()));
        }
        return mapper.mapToResponseElementRepairDto(repair);
    }

    @Override
    public ResponseElementRepairDto update(ElementRepairDto repairDto) {
        if (repository.existsById(repairDto.getId())) {
            ElementRepair repair = repository.save(mapper.mapToElementRepair(repairDto
                                                          , getActionsOnParameter(repairDto.getActionsOnParameter())));
            repair.setMeasuredParameters(parameterService.update(repairDto.getMeasuredParameters()));
            return mapper.mapToResponseElementRepairDto(repair);
        }
        throw new NotFoundException(String.format("Repair method with id=%s not found for update", repairDto.getId()));
    }

    @Override
    public ResponseElementRepairDto get(Long id) {
        return mapper.mapToResponseElementRepairDto( repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Repair method with id=%s not found", id))));
    }

    @Override
    public List<ResponseShortElementRepairDto> getAll() {
        return repository.findAll()
                         .stream()
                         .map(mapper::mapToResponseShortElementRepairDto)
                         .toList();
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("Repair method with id=%s not found for delete", id));
    }

    private ActionsOnParameter getActionsOnParameter(String actions) {
        return ActionsOnParameter.from(actions).orElseThrow(
                () -> new BadRequestException(String.format("Unsupported type actionsOnParameter=%s", actions)));
    }
}