package ru.nabokovsg.laboratoryNK.mapper.equipmentDiagnosed;

import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.dto.equipmentDiagnosed.passport.EquipmentPassportDto;
import ru.nabokovsg.laboratoryNK.dto.equipmentDiagnosed.passport.ResponseEquipmentPassportDto;
import ru.nabokovsg.laboratoryNK.model.equipmentDiagnosed.EquipmentDiagnosed;
import ru.nabokovsg.laboratoryNK.model.equipmentDiagnosed.EquipmentPassport;

public interface EquipmentPassportMapper {

    @Mapping(source = "passportDto.sequentialNumber", target = "sequentialNumber")
    @Mapping(source = "passportDto.header", target = "header")
    @Mapping(source = "passportDto.meaning", target = "meaning")
    @Mapping(source = "equipment", target = "equipment")
    @Mapping(source = "passportDto.id", target = "id")
    EquipmentPassport mapToEquipmentPassport(EquipmentPassportDto passportDto, EquipmentDiagnosed equipment);

    ResponseEquipmentPassportDto mapToFullEquipmentPassportDto(EquipmentPassport passport);
}