package ru.nabokovsg.laboratoryNK.service.equipmentDiagnosed;

import ru.nabokovsg.laboratoryNK.dto.equipmentDiagnosed.equipmentType.ResponseEquipmentTypeDto;
import ru.nabokovsg.laboratoryNK.dto.equipmentDiagnosed.equipments.EquipmentDto;
import ru.nabokovsg.laboratoryNK.model.equipmentDiagnosed.EquipmentType;

import java.util.List;

public interface EquipmentTypeService {

    EquipmentType create(EquipmentDto equipmentDto);

    List<ResponseEquipmentTypeDto> getAll();
}