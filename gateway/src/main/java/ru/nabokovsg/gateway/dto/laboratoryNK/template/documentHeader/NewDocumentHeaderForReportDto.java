package ru.nabokovsg.gateway.dto.laboratoryNK.template.documentHeader;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные для добавления заголовка отчета")
public class NewDocumentHeaderForReportDto {

    @Schema(description = "Индентификатор типа документа диагностики")
    @NotNull(message = "document type id should not be null")
    @Positive(message = "document type id can only be positive")
    private Long documentTypeId;
    @Schema(description = "Тип структурного подразделения организации")
    @NotBlank(message = "division type should not be blank")
    private String divisionType;
    @Schema(description = "Индентификатор структурного подразделения организации")
    @NotNull(message = "division id should not be null")
    @Positive(message = "division id can only be positive")
    private Long divisionId;
    @Schema(description = "Указать лицензию/аттестацию")
    @NotNull(message = "specifyLicense should not be null")
    private Boolean specifyLicense;
}