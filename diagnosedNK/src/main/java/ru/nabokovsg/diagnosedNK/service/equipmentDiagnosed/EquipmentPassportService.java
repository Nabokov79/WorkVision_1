package ru.nabokovsg.diagnosedNK.service.equipmentDiagnosed;

import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.passport.EquipmentPassportDto;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.passport.ResponseEquipmentPassportDto;

public interface EquipmentPassportService {

    ResponseEquipmentPassportDto save(EquipmentPassportDto passportDto);

    ResponseEquipmentPassportDto update(EquipmentPassportDto passportDto);

    void delete(Long id);
}