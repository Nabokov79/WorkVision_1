package ru.nabokovsg.diagnosedNK.mapper.measurement.utm;

import org.mapstruct.Mapper;
import ru.nabokovsg.diagnosedNK.model.measurement.utm.ResultUltrasonicThicknessMeasurement;
import ru.nabokovsg.diagnosedNK.model.measurement.utm.UltrasonicThicknessMeasurement;

@Mapper(componentModel = "spring")
public interface ResultUltrasonicThicknessMeasurementServiceMapper {

    ResultUltrasonicThicknessMeasurement mapToCalculatingUltrasonicThicknessMeasurement(
                                                                            UltrasonicThicknessMeasurement measurement);
}