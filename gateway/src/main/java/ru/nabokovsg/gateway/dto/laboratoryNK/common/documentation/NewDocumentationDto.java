package ru.nabokovsg.gateway.dto.laboratoryNK.common.documentation;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные для добавления данных нормативно-технической документации")
public class NewDocumentationDto {

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