package ru.nabokovsg.gateway.dto.laboratoryNK.common.documentation;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения данных нормативно-технической документации")
public class UpdateDocumentationDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id should not be null")
    @Positive(message = "id can only be positive")
    private Long id;
    @Schema(description = "Вид документа")
    @NotBlank(message = "documentation view should not be blank")
    private String view;
    @Schema(description = "Номер документа")
    @NotBlank(message = "documentation number should not be blank")
    private String number;
    @Schema(description = "Заголовок документа")
    @NotBlank(message = "documentation title should not be blank")
    private String title;
}