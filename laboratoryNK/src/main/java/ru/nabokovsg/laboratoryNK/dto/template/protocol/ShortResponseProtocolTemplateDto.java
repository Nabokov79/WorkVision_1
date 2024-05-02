package ru.nabokovsg.laboratoryNK.dto.template.protocol;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.laboratoryNK.dto.template.documentHeader.ResponseDocumentHeaderDto;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Краткие данные протокола/заключения по обследованию")
public class ShortResponseProtocolTemplateDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Заголовок")
    private ResponseDocumentHeaderDto leftHeaderTemplate;
    @Schema(description = "Название документа")
    private String title;
    @Schema(description = "Заголовок документа")
    private String subtitle;
}