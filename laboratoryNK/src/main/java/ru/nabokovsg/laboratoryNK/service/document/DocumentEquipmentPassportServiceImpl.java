package ru.nabokovsg.laboratoryNK.service.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.client.LaboratoryClient;
import ru.nabokovsg.laboratoryNK.mapper.document.DocumentEquipmentPassportMapper;
import ru.nabokovsg.laboratoryNK.model.document.report.Section;
import ru.nabokovsg.laboratoryNK.repository.document.DocumentEquipmentPassportRepository;

@Service
@RequiredArgsConstructor
public class DocumentEquipmentPassportServiceImpl implements DocumentEquipmentPassportService {

    private final DocumentEquipmentPassportRepository repository;
    private final DocumentEquipmentPassportMapper mapper;
    private final LaboratoryClient client;

    @Override
    public void saveForSection(Section section, Long equipmentDiagnosedId) {
       repository.saveAll(
               client.getEquipmentPassportDto(equipmentDiagnosedId)
                       .stream()
                       .map(p -> mapper.mapToDocumentEquipmentPassport(buildHeader(section.getSequentialNumber()
                                                                                 , p.getSequentialNumber())
                                                                                 , p.getMeaning()
                                                                                 , section))
                       .toList()
       );
    }

    private String buildHeader(Integer firstSequentialNumber, Integer secondSequentialNumber) {
        return String.join(".", String.valueOf(firstSequentialNumber), String.valueOf(secondSequentialNumber));
    }
}