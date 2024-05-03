package ru.nabokovsg.laboratoryNK.service.equipmentDiagnosed;

import ru.nabokovsg.laboratoryNK.dto.equipmentDiagnosed.equipmentType.EquipmentTypeDto;
import ru.nabokovsg.laboratoryNK.dto.equipmentDiagnosed.equipmentType.ResponseEquipmentTypeDto;
import ru.nabokovsg.laboratoryNK.model.equipmentDiagnosed.EquipmentType;;

import java.util.List;

public interface EquipmentTypeService {

    ResponseEquipmentTypeDto save(EquipmentTypeDto elementTypeDto);

    ResponseEquipmentTypeDto update(EquipmentTypeDto elementTypeDto);

   ResponseEquipmentTypeDto get(Long id);

    List<ResponseEquipmentTypeDto> getAll();

    void delete(Long id);

    EquipmentType getById(Long id);
}