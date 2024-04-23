package ru.nabokovsg.laboratoryNK.dto.equipmentDiagnosed.equipments;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные оборудования")
public class EquipmentDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Индентификатор котельной, цтп")
    private Long buildingId;
    @Schema(description = "Наименование")
    private String equipmentName;
    @Schema(description = "Стационарный номер")
    private Integer stationaryNumber;
    @Schema(description = "Объем")
    private Integer volume;
    @Schema(description = "Старый или новый бак-аккумулятор")
    private Boolean old;
    @Schema(description = "Модель")
    private String model;
}