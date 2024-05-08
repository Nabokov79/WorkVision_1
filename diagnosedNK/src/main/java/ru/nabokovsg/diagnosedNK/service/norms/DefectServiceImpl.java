package ru.nabokovsg.diagnosedNK.service.norms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.diagnosedNK.dto.norms.defects.DefectDto;
import ru.nabokovsg.diagnosedNK.dto.norms.defects.ResponseDefectDto;
import ru.nabokovsg.diagnosedNK.dto.norms.defects.ResponseShortDefectDto;
import ru.nabokovsg.diagnosedNK.exceptions.BadRequestException;
import ru.nabokovsg.diagnosedNK.exceptions.NotFoundException;
import ru.nabokovsg.diagnosedNK.mapper.norms.DefectMapper;
import ru.nabokovsg.diagnosedNK.model.norms.ActionsOnParameter;
import ru.nabokovsg.diagnosedNK.model.norms.Defect;
import ru.nabokovsg.diagnosedNK.repository.norms.DefectRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefectServiceImpl implements DefectService {

    private final DefectRepository repository;
    private final DefectMapper mapper;
    private final MeasuredParameterService parameterService;

    @Override
    public ResponseDefectDto save(DefectDto defectDto) {
        Defect defect = repository.findByDefectName(defectDto.getDefectName());
        if (defect == null) {
            defect = repository.save(mapper.mapToDefect(defectDto
                                                      , getActionsOnParameter(defectDto.getActionsOnParameter())));
            defect.setMeasuredParameters(parameterService.saveForDefect(defect, defectDto.getMeasuredParameters()));
        }
        return mapper.mapToResponseDefectDto(defect);
    }

    @Override
    public ResponseDefectDto update(DefectDto defectDto) {
        if (repository.existsById(defectDto.getId())) {
            Defect defect = repository.save(mapper.mapToDefect(defectDto
                                                           , getActionsOnParameter(defectDto.getActionsOnParameter())));
            defect.setMeasuredParameters(parameterService.saveForDefect(defect, defectDto.getMeasuredParameters()));
            return mapper.mapToResponseDefectDto(defect);
        }
        throw new NotFoundException(String.format("Defect with id=%s not found for update", defectDto.getId()));
    }

    @Override
    public ResponseDefectDto get(Long id) {
        return mapper.mapToResponseDefectDto(getById(id));
    }

    @Override
    public List<ResponseShortDefectDto> getAll() {
        return repository.findAll()
                         .stream()
                         .map(mapper::mapToResponseShortDefectDto)
                         .toList();
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("Defect with id=%s not found for delete", id));
    }

    @Override
    public Defect getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Defect with id=%s not found", id)));
    }

    private ActionsOnParameter getActionsOnParameter(String actions) {
        return ActionsOnParameter.from(actions).orElseThrow(
                () -> new BadRequestException(String.format("Unsupported type actionsOnParameter=%s", actions)));
    }
}