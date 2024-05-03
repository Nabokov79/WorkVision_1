package ru.nabokovsg.measurementNK.service.norms;

import ru.nabokovsg.measurementNK.dto.norms.defects.DefectDto;
import ru.nabokovsg.measurementNK.dto.norms.defects.ResponseDefectDto;
import ru.nabokovsg.measurementNK.dto.norms.defects.ResponseShortDefectDto;

import java.util.List;

public interface DefectService {

    ResponseDefectDto save(DefectDto defectDto);

    ResponseDefectDto update(DefectDto defectDto);

    ResponseDefectDto get(Long id);

    List<ResponseShortDefectDto> getAll();

    void delete(Long id);
}