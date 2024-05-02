package ru.nabokovsg.laboratoryNK.dto.template.regulatoryDocumentationTemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные шаблона нормативно-технической документации")
public class ResponseRegulatoryDocumentationTemplateDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Column(name = "sequential_number")
    private Integer sequentialNumber;
    @Column(name = "document_name")
    private String documentName;
}