package ru.nabokovsg.diagnosedNK.mapper.equipmentDiagnosed;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.passport.EquipmentPassportDto;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.passport.ResponseEquipmentPassportDto;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.EquipmentDiagnosed;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.EquipmentPassport;

@Mapper(componentModel = "spring")
public interface EquipmentPassportMapper {

    @Mapping(source = "passportDto.sequentialNumber", target = "sequentialNumber")
    @Mapping(source = "passportDto.header", target = "header")
    @Mapping(source = "passportDto.meaning", target = "meaning")
    @Mapping(source = "passportDto.useToProtocol", target = "useToProtocol")
    @Mapping(source = "equipmentDiagnosed", target = "equipmentDiagnosed")
    @Mapping(source = "passportDto.id", target = "id")
    EquipmentPassport mapToEquipmentPassport(EquipmentPassportDto passportDto, EquipmentDiagnosed equipmentDiagnosed);

    ResponseEquipmentPassportDto mapToResponseEquipmentPassportDto(EquipmentPassport passport);
}