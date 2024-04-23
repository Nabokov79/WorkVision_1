package ru.nabokovsg.laboratoryNK.dto.equipmentDiagnosed.equipments;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.laboratoryNK.dto.equipmentDiagnosed.element.ResponseElementDto;
import ru.nabokovsg.laboratoryNK.dto.equipmentDiagnosed.equipmentType.ResponseEquipmentTypeDto;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Полные данные оборудования")
public class ResponseEquipmentDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Тип оборудования")
    private ResponseEquipmentTypeDto equipmentType;
    @Schema(description = "Полное наименование")
    private String fullName;
    @Schema(description = "Стационарный номер")
    private Integer stationaryNumber;
    @Schema(description = "Объем")
    private Integer volume;
    @Schema(description = "Модель")
    private String model;
    @Schema(description = "Элементы оборудования")
    private List<ResponseElementDto> elements;
}