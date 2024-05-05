package ru.nabokovsg.diagnosedNK.mapper.norms;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.diagnosedNK.model.norms.ElementRepair;
import ru.nabokovsg.diagnosedNK.model.norms.MeasuredParameter;
import ru.nabokovsg.diagnosedNK.model.norms.Defect;
@Mapper(componentModel = "spring")
public interface MeasuredParameterMapper {

    @Mapping(source = "parameterMeasurement", target = "parameterName")
    @Mapping(source = "unitMeasurement", target = "unitMeasurement")
    @Mapping(source = "defect", target = "defect")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "elementRepair", ignore = true)
    MeasuredParameter mapForDefect(String parameterMeasurement, String unitMeasurement, Defect defect);

    @Mapping(source = "parameterMeasurement", target = "parameterName")
    @Mapping(source = "unitMeasurement", target = "unitMeasurement")
    @Mapping(source = "elementRepair", target = "elementRepair")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "defect", ignore = true)
    MeasuredParameter mapForElementRepair(String parameterMeasurement
                                        , String unitMeasurement
                                        , ElementRepair elementRepair);

    @Mapping(source = "parameterMeasurement", target = "parameterName")
    @Mapping(source = "unitMeasurement", target = "unitMeasurement")
    @Mapping(source = "id", target = "id")
    MeasuredParameter mapToUpdateMeasuredParameter(Long id, String parameterMeasurement, String unitMeasurement);
}