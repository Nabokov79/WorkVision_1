package ru.nabokovsg.diagnosedNK.service.equipmentDiagnosed;

import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.standardSize.StandardSizeDto;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.StandardSize;
import ru.nabokovsg.diagnosedNK.model.measurement.utm.ResultUltrasonicThicknessMeasurement;

public interface StandardSizeService {

    StandardSize save(StandardSizeDto standardSizeDto);

    StandardSize update(StandardSizeDto standardSizeDto);

    StandardSize getByPredicate(ResultUltrasonicThicknessMeasurement measurement);
}