package ru.nabokovsg.laboratoryNK.mapper.template;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.nabokovsg.laboratoryNK.dto.client.BranchDto;
import ru.nabokovsg.laboratoryNK.dto.client.DepartmentDto;
import ru.nabokovsg.laboratoryNK.dto.client.DivisionDto;
import ru.nabokovsg.laboratoryNK.dto.template.subsectionTemplate.ResponseSubsectionTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.subsectionTemplate.SubsectionTemplateDto;
import ru.nabokovsg.laboratoryNK.model.template.SubsectionTemplate;
import ru.nabokovsg.laboratoryNK.model.template.TableTemplate;
import ru.nabokovsg.laboratoryNK.model.template.protocol.ProtocolControlTemplate;
import ru.nabokovsg.laboratoryNK.model.template.protocol.ProtocolTemplate;
import ru.nabokovsg.laboratoryNK.model.template.report.ProtocolReportTemplate;
import ru.nabokovsg.laboratoryNK.model.template.report.SectionTemplate;

@Mapper(componentModel = "spring")
public interface SubsectionTemplateMapper {

    SubsectionTemplate mapToSubsectionTemplate(SubsectionTemplateDto subsectionDto);

    @Mapping(source = "tableTemplate", target = "tableTemplate")
    @Mapping(target = "sequentialNumber", ignore = true)
    @Mapping(target = "protocolReportTemplate", ignore = true)
    @Mapping(target = "id", ignore = true)
    SubsectionTemplate mapWithTableTemplate(@MappingTarget SubsectionTemplate subsectionsTemplate
                                                         , TableTemplate tableTemplate);

    @Mapping(source = "protocolReportTemplate", target = "protocolReportTemplate")
    @Mapping(target = "sequentialNumber", ignore = true)
    @Mapping(target = "sectionTemplate", ignore = true)
    @Mapping(target = "id", ignore = true)
    SubsectionTemplate mapWithProtocolReportTemplate(@MappingTarget SubsectionTemplate subsectionsTemplate
                                                                  , ProtocolReportTemplate protocolReportTemplate);

    @Mapping(source = "division", target = "division")
    SubsectionTemplate mapWithDivisionContact(@MappingTarget SubsectionTemplate subsectionsTemplate
                                                           , String division);

    @Mapping(source = "sectionTemplate", target = "sectionTemplate")
    @Mapping(target = "sequentialNumber", ignore = true)
    @Mapping(target = "id", ignore = true)
    SubsectionTemplate mapWithSectionTemplate(@MappingTarget SubsectionTemplate subsectionsTemplate
                                                           , SectionTemplate sectionTemplate);

    @Mapping(source = "protocolTemplate", target = "protocolTemplate")
    @Mapping(target = "sequentialNumber", ignore = true)
    @Mapping(target = "id", ignore = true)
    SubsectionTemplate mapWithProtocolTemplate(@MappingTarget SubsectionTemplate subsectionsTemplate
                                                            , ProtocolTemplate protocolTemplate);

    @Mapping(source = "protocolControlTemplate", target = "protocolControlTemplate")
    @Mapping(target = "sequentialNumber", ignore = true)
    @Mapping(target = "id", ignore = true)
    SubsectionTemplate mapWithProtocolControlTemplate(@MappingTarget SubsectionTemplate subsectionsTemplate
                                                                   , ProtocolControlTemplate protocolControlTemplate);

    ResponseSubsectionTemplateDto mapToResponseSubsectionTemplateDto(SubsectionTemplate subsection);

    DivisionDto mapFromBranch(BranchDto branchDto);

    DivisionDto mapFromDepartment(DepartmentDto departmentDto);
}