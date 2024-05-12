package ru.nabokovsg.diagnosedNK.mapper.equipmentDiagnosed;

import org.mapstruct.Mapping;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.passport.EquipmentPassportDto;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.passport.ResponseEquipmentPassportDto;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.EquipmentDiagnosed;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.EquipmentPassport;

public interface EquipmentPassportMapper {

    @Mapping(source = "passportDto.sequentialNumber", target = "sequentialNumber")
    @Mapping(source = "passportDto.header", target = "header")
    @Mapping(source = "passportDto.meaning", target = "meaning")
    @Mapping(source = "equipment", target = "equipment")
    @Mapping(source = "passportDto.id", target = "id")
    EquipmentPassport mapToEquipmentPassport(EquipmentPassportDto passportDto, EquipmentDiagnosed equipment);

    ResponseEquipmentPassportDto mapToResponseEquipmentPassportDto(EquipmentPassport passport);
}