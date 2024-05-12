package ru.nabokovsg.laboratoryNK.service.document;

import ru.nabokovsg.laboratoryNK.model.document.report.Section;

public interface DocumentEquipmentPassportService {

    void saveForSection(Section section, Long equipmentDiagnosedId);
}