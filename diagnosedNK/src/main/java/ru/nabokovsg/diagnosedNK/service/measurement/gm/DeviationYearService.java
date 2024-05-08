package ru.nabokovsg.diagnosedNK.service.measurement.gm;

import ru.nabokovsg.diagnosedNK.model.measurement.gm.ReferencePoint;

import java.util.List;

public interface DeviationYearService {

    void save(List<ReferencePoint> points);

    void update(List<ReferencePoint> points);
}