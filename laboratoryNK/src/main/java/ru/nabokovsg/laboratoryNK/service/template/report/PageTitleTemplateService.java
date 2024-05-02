package ru.nabokovsg.laboratoryNK.service.template.report;

import ru.nabokovsg.laboratoryNK.dto.template.report.pageTitle.PageTitleTemplateDto;
import ru.nabokovsg.laboratoryNK.dto.template.report.pageTitle.ResponsePageTitleTemplateDto;

public interface PageTitleTemplateService {

    ResponsePageTitleTemplateDto save(PageTitleTemplateDto pageTitleDto);

    ResponsePageTitleTemplateDto update(PageTitleTemplateDto pageTitleDto);

    ResponsePageTitleTemplateDto get(Long id);

    void delete(Long id);
}