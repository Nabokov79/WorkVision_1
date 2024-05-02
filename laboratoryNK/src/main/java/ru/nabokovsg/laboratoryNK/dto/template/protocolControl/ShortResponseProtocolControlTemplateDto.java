package ru.nabokovsg.laboratoryNK.dto.template.protocolControl;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.laboratoryNK.dto.template.documentHeader.ResponseDocumentHeaderDto;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "ДКраткие днные протокола/заключения по контролю качества")
public class ShortResponseProtocolControlTemplateDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Заголовок")
    private ResponseDocumentHeaderDto leftHeaderTemplate;
    @Schema(description = "Название документа")
    private String title;
    @Schema(description = "Заголовок документа")
    private String subtitle;
}