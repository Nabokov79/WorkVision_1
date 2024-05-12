package ru.nabokovsg.laboratoryNK.service.document;

import ru.nabokovsg.laboratoryNK.model.document.DocumentTable;
import ru.nabokovsg.laboratoryNK.model.template.ColumnHeaderTemplate;

import java.util.Set;

public interface CellTableService {

    void saveEquipmentInspection(DocumentTable table, Set<ColumnHeaderTemplate> columnHeaders);

    void saveEquipmentRepair(DocumentTable table, Set<ColumnHeaderTemplate> columnHeaders);
}