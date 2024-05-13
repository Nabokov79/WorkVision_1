package ru.nabokovsg.gateway.dto.laboratoryNK.diagnosticDocument.diagnosticDocumentsType;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для добавления вида документа диагностики")
public class NewDiagnosticDocumentTypeDto {

    @Schema(description = "Название документа")
    @NotBlank(message = "title should not be blank")
    private String title;
    @Schema(description = "Заголовок документа")
    @NotBlank(message = "heading should not be blank")
    private String heading;
    @Schema(description = "Тип документа")
    @NotBlank(message = "type document should not be blank")
    private String typeDocument;
}