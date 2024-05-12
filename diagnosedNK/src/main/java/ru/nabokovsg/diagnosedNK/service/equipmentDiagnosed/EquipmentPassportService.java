package ru.nabokovsg.diagnosedNK.service.equipmentDiagnosed;

import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.passport.EquipmentPassportDto;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.passport.ResponseEquipmentPassportDto;

import java.util.List;

public interface EquipmentPassportService {

    ResponseEquipmentPassportDto save(EquipmentPassportDto passportDto);

    ResponseEquipmentPassportDto update(EquipmentPassportDto passportDto);

    List<ResponseEquipmentPassportDto> getAll(Long id);

    void delete(Long id);
}