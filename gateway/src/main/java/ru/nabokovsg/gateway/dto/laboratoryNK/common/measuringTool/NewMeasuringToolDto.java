package ru.nabokovsg.gateway.dto.laboratoryNK.common.measuringTool;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для добавления измерительнго инструменте(приборе)")
public class NewMeasuringToolDto {

    @Schema(description = "Название")
    @NotBlank(message = "toll should not be blank")
    private String toll;
    @Schema(description = "Модель")
    @NotBlank(message = "model should not be blank")
    private String model;
    @Schema(description = "Заводской номер")
    @NotBlank(message = "work number should not be blank")
    private String workNumber;
    @Schema(description = "Назначение")
    @NotBlank(message = "purpose should not be blank")
    private String purpose;
    @Schema(description = "Дата изготовления")
    @NotNull(message = "manufacturing should not be blank")
    private LocalDate manufacturing;
    @Schema(description = "Дата начала эксплуатации")
    @NotNull(message = "exploitation should not be blank")
    private LocalDate exploitation;
    @Schema(description = "Индентификатор организации-изготовителя")
    @NotBlank(message = "manufacturer should not be blank")
    private String manufacturer;
    @Schema(description = "Диапазон измерений")
    @NotBlank(message = "measuring range should not be blank")
    private String  measuringRange;
    @Schema(description = "Характеристики")
    @NotBlank(message = "characteristics should not be blank")
    private String characteristics;
    @Schema(description = "Индентификатор владелеца средства(прибора)")
    @NotBlank(message = "owner should not be blank")
    private Long owner;
    @Schema(description = "Дата поверки")
    @NotNull(message = "verification date should not be blank")
    private LocalDate verificationDate;
    @Schema(description = "Дата следующей поверки")
    @NotNull(message = "next verification date should not be blank")
    private LocalDate nextVerificationDate;
    @Schema(description = "Индентификатор метрологической организации")
    @NotBlank(message = "organization should not be blank")
    private String organization;
    @Schema(description = "Номер свидетельства о поверке")
    @NotBlank(message = "certificate number should not be blank")
    private String certificateNumber;
    @Schema(description = "Номер госреестра")
    @NotBlank(message = "registry should not be blank")
    private String registry;
    @Schema(description = "Примечание")
    private String note;
    @Schema(description = "Вид контроля")
    private String controlType;
    @Schema(description = "Индентификатор сотрудника")
    private Long employeeId;
}