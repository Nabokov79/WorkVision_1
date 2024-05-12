package ru.nabokovsg.laboratoryNK.service.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.mapper.document.TableMapper;
import ru.nabokovsg.laboratoryNK.model.document.DocumentTable;
import ru.nabokovsg.laboratoryNK.model.document.report.ProtocolReport;
import ru.nabokovsg.laboratoryNK.model.template.ColumnHeaderTemplate;
import ru.nabokovsg.laboratoryNK.model.template.TableTemplate;
import ru.nabokovsg.laboratoryNK.model.template.TableType;
import ru.nabokovsg.laboratoryNK.repository.document.TableRepository;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TableServiceImpl implements TableService {

    private final TableRepository repository;
    private final TableMapper mapper;
    private final CellTableService cellTableService;

    @Override
    public DocumentTable savaForSubsection(TableTemplate tableTemplate) {
        DocumentTable table = repository.save(mapper.mapToDocumentTable(tableTemplate));
        common(table, tableTemplate.getColumnHeaders(), tableTemplate.getTableType());
        return table;
    }

    @Override
    public void savaForProtocolReport(ProtocolReport protocol, Set<TableTemplate> templates) {
        Map<Integer, TableTemplate> tableTemplates = templates.stream()
                                                 .collect(Collectors.toMap(TableTemplate::getSequentialNumber, t -> t));
        repository.saveAll(templates.stream()
                                    .map(t -> mapper.mapWithProtocolReport(t, protocol))
                                    .toList())
                .forEach(t -> common(t
                                   , tableTemplates.get(t.getSequentialNumber())
                                                         .getColumnHeaders()
                                   , tableTemplates.get(t.getSequentialNumber())
                                                   .getTableType()));
    }

    private void common(DocumentTable table, Set<ColumnHeaderTemplate> templates, String tableType) {
        TableType type = TableType.valueOf(tableType);
        switch (type) {
            case SURVEYS_TABLE -> cellTableService.saveEquipmentInspection(table, templates);
            case REPAIR_TABLE -> cellTableService.saveEquipmentRepair(table, templates);
            case TABLE_VMS -> cellTableService.saveEquipmentRepair(table, templates);
            case TABLE_VMC -> cellTableService.saveEquipmentRepair(table, templates);
            case TABLE_UM -> cellTableService.saveEquipmentRepair(table, templates);
            case MEASUREMENT_RP -> cellTableService.saveEquipmentRepair(table, templates);
            case MEASUREMENT_CP -> cellTableService.saveEquipmentRepair(table, templates);
            case TABLE_UC -> cellTableService.saveEquipmentRepair(table, templates);
            case MEASUREMENT_HARDNESS -> cellTableService.saveEquipmentRepair(table, templates);
        }
    }
}