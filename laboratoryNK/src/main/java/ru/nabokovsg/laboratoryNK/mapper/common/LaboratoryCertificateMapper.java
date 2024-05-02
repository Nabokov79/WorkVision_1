package ru.nabokovsg.laboratoryNK.mapper.common;

import org.mapstruct.Mapper;
import ru.nabokovsg.laboratoryNK.dto.common.laboratoryCertificate.LaboratoryCertificateDto;
import ru.nabokovsg.laboratoryNK.model.common.LaboratoryCertificate;

@Mapper(componentModel = "spring")
public interface LaboratoryCertificateMapper {

    LaboratoryCertificate mapToLaboratoryCertificate(LaboratoryCertificateDto certificateDto);

    LaboratoryCertificateDto mapToLaboratoryCertificateDto(LaboratoryCertificate certificate);
}