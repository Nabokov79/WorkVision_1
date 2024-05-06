package ru.nabokovsg.gateway.dto.company.building;

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
@Schema(description = "Информация для изменения данных энергетических источников")
public class UpdateBuildingDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id should not be blank")
    @Positive(message = "id must be positive")
    private Long id;
    @Schema(description = "Тип строения")
    @NotBlank(message = "building type should not be blank")
    private String buildingType;
    @Schema(description = "Название")
    private String login;
    @Schema(description = "Индентификатор участка теплоснабжения")
    @NotNull(message = "exploitation region id should not be null")
    @Positive(message = "exploitation region id can only be positive")
    private Long exploitationRegionId;
    @Schema(description = "Индентификатор адреса")
    @NotNull(message = "address id should not be blank")
    @Positive(message = "address id can only be positive")
    private Long addressId;
}