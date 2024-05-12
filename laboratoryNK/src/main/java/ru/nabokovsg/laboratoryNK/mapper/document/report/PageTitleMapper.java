package ru.nabokovsg.laboratoryNK.mapper.document.report;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.laboratoryNK.model.document.report.PageTitle;
import ru.nabokovsg.laboratoryNK.model.laboratoryEmployee.LaboratoryEmployee;
import ru.nabokovsg.laboratoryNK.model.template.report.PageTitleTemplate;

@Mapper(componentModel = "spring")
public interface PageTitleMapper {

    @Mapping(target = "id", ignore = true)
    PageTitle mapToPageTitle(PageTitleTemplate pageTitleTemplate
                           , LaboratoryEmployee chief
                           , String numberAndDate
                           , String year
                           , String address);
}