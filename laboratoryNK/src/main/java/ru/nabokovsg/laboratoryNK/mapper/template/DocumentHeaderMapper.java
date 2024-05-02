package ru.nabokovsg.laboratoryNK.mapper.template;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.dto.client.*;
import ru.nabokovsg.laboratoryNK.dto.template.documentHeader.DocumentHeaderDto;
import ru.nabokovsg.laboratoryNK.dto.template.documentHeader.ResponseDocumentHeaderDto;
import ru.nabokovsg.laboratoryNK.model.template.DivisionType;
import ru.nabokovsg.laboratoryNK.model.template.DocumentHeader;

@Mapper(componentModel = "spring")
public interface DocumentHeaderMapper {

    @Mapping(source = "headerDto.id", target = "id")
    @Mapping(source = "headerDto.documentTypeId", target = "documentTypeId")
    @Mapping(source = "divisionType", target = "divisionType")
    @Mapping(source = "division", target = "division")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "certificate", target = "certificate")
    @Mapping(source = "contacts", target = "contacts")
    DocumentHeader mapToDocumentHeader(DocumentHeaderDto headerDto
                                     , DivisionType divisionType
                                     , String division
                                     , String address
                                     , String certificate
                                     , String contacts);
    ResponseDocumentHeaderDto mapToResponseDocumentHeaderDto(DocumentHeader documentHeader);

    DivisionDto mapFromOrganization(OrganizationDto organization);

    DivisionDto mapFromBranch(BranchDto branch);

    DivisionDto mapFromDepartment(DepartmentDto department);

    DivisionDto mapFromHeatSupplyAreaDto(HeatSupplyAreaDto heatSupplyArea);

    DivisionDto mapFromExploitationRegionDto(ExploitationRegionDto exploitationRegion);
}