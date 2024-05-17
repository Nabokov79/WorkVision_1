package ru.nabokovsg.gateway.dto.diagnosedNK.equipmentDiagnosed.element;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.gateway.dto.diagnosedNK.equipmentDiagnosed.standardSize.UpdateStandardSizeDto;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения элемента оборудования")
public class UpdateElementDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id should not be null")
    @Positive(message = "id can only be positive")
    private Long id;
    @Schema(description = "Индентификатор оборудования")
    @NotNull(message = "equipment id should not be null")
    @Positive(message = "equipment id can only be positive")
    private Long equipmentId;
    @Schema(description = "Наименование элемента")
    @NotBlank(message = "elementName should not be blank")
    private String elementName;
    @Schema(description = "Типоразмер")
    private UpdateStandardSizeDto standardSize;
}