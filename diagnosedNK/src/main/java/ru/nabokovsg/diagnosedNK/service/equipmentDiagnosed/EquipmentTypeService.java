package ru.nabokovsg.diagnosedNK.service.equipmentDiagnosed;

import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.equipmentType.EquipmentTypeDto;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.equipmentType.ResponseEquipmentTypeDto;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.EquipmentType;

import java.util.List;

public interface EquipmentTypeService {

    ResponseEquipmentTypeDto save(EquipmentTypeDto equipmentTypeDto);

    ResponseEquipmentTypeDto update(EquipmentTypeDto equipmentTypeDto);

   ResponseEquipmentTypeDto get(Long id);

    List<ResponseEquipmentTypeDto> getAll();

    void delete(Long id);

    EquipmentType getById(Long id);
}