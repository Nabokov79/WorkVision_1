package ru.nabokovsg.company.dto.organization;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Краткие сведения об организации")
public class ShortResponseOrganizationDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Полное наименование организации")
    private String fullName;
    @Schema(description = "Краткое наименование организации")
    private String shortName;
}