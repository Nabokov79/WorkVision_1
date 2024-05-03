package ru.nabokovsg.measurementNK.dto.norms.acceptableHardness;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные для добавления/изменения допустимых толщин элементов оборудования")
public class AcceptableHardnessDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Индентификатор типа оборудования")
    private Long equipmentTypeId;
    @Schema(description = "Индентификатор элемента оборудования")
    private Long elementId;
    @Schema(description = "Минимальная допустимая твердость металла элемента")
    private Integer minHardness;
    @Schema(description = "Максимальная допустимая твердость металла элемента")
    private Integer maxHardness;
    @Schema(description = "Допустимая погрешность измерения")
    private Float measurementError;
}
