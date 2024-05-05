package ru.nabokovsg.diagnosedNK.service.equipmentDiagnosed;

import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.equipments.EquipmentDto;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.equipments.ResponseEquipmentDto;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.equipments.ResponseShortEquipmentDto;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.EquipmentDiagnosed;

import java.util.List;

public interface EquipmentDiagnosedService {

    ResponseShortEquipmentDto save(EquipmentDto equipmentDto);

    ResponseShortEquipmentDto update(EquipmentDto equipmentDto);

    ResponseEquipmentDto get(Long id, Boolean full);

    List<ResponseShortEquipmentDto> getAll(Long id);

    void delete(Long id);

    EquipmentDiagnosed getById(Long id);
}