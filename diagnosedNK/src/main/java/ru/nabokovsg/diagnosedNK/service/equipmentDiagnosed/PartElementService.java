package ru.nabokovsg.diagnosedNK.service.equipmentDiagnosed;

import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.partElement.PartElementDto;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.partElement.ResponsePartElementDto;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.partElement.ShortResponsePartElementDto;

import java.util.List;

public interface PartElementService {

    ResponsePartElementDto save(PartElementDto partElementDto);

    ResponsePartElementDto update(PartElementDto partElementDto);

    ResponsePartElementDto get(Long id);

    List<ShortResponsePartElementDto> getAll(Long id);

    void delete(Long id);
}