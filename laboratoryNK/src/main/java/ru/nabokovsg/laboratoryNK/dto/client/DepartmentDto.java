package ru.nabokovsg.laboratoryNK.dto.client;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Schema(description = "Данные подразделения")
public class DepartmentDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Полное название")
    private String fullName;
    @Schema(description = "Краткое название")
    private String shortName;
    @Schema(description = "Адрес")
    private AddressDto address;
}