package ru.nabokovsg.laboratoryNK.service.document;

import ru.nabokovsg.laboratoryNK.model.document.Subsection;
import ru.nabokovsg.laboratoryNK.model.laboratoryEmployee.LaboratoryEmployee;
import ru.nabokovsg.laboratoryNK.model.template.MeasuringToolTemplate;

import java.util.List;
import java.util.Set;

public interface DocumentMeasuringToolService {

    void save(Subsection subsection
            , Set<LaboratoryEmployee> employees
            , List<MeasuringToolTemplate> measuringToolsTemplates);
}
