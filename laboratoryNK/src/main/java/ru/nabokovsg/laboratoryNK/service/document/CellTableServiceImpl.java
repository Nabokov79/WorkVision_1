package ru.nabokovsg.laboratoryNK.service.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.model.document.DocumentTable;
import ru.nabokovsg.laboratoryNK.model.template.ColumnHeaderTemplate;
import ru.nabokovsg.laboratoryNK.repository.document.CellTableRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CellTableServiceImpl implements CellTableService {

    private final CellTableRepository repository;

    @Override
    public void saveEquipmentInspection(DocumentTable table, Set<ColumnHeaderTemplate> columnHeaders) {

    }

    @Override
    public void saveEquipmentRepair(DocumentTable table, Set<ColumnHeaderTemplate> columnHeaders) {

    }
}