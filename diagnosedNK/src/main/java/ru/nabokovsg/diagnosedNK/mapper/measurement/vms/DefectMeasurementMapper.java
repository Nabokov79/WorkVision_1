package ru.nabokovsg.diagnosedNK.mapper.measurement.vms;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.DefectMeasurementDto;
import ru.nabokovsg.diagnosedNK.dto.measurement.vms.ResponseDefectMeasurementDto;
import ru.nabokovsg.diagnosedNK.model.measurement.vms.DefectMeasurement;
import ru.nabokovsg.diagnosedNK.model.norms.Defect;

@Mapper(componentModel = "spring")
public interface DefectMeasurementMapper {

    @Mapping(source = "defectMeasurementDto.elementId", target = "elementId")
    @Mapping(source = "defectMeasurementDto.partElementId", target = "partElementId")
    @Mapping(source = "defect.id", target = "defectId")
    @Mapping(source = "defect.defectName", target = "defectName")
    @Mapping(source = "defectMeasurementDto.id", target = "id")
    @Mapping(target = "parameters", ignore = true)
    DefectMeasurement mapToDefectMeasurement(DefectMeasurementDto defectMeasurementDto
                                           , Defect defect);

    ResponseDefectMeasurementDto mapToResponseDefectMeasurementDto(DefectMeasurement defectMeasurement);
}