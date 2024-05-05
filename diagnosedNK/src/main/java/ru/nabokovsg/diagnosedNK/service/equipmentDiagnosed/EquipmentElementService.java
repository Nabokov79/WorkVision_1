package ru.nabokovsg.diagnosedNK.service.equipmentDiagnosed;

import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.element.ElementDto;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.element.ResponseElementDto;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.element.ShortResponseElementDto;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.EquipmentElement;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.PartElement;

import java.util.List;

public interface EquipmentElementService {

    ShortResponseElementDto save(ElementDto elementDto);

    ShortResponseElementDto update(ElementDto elementDto);

    ResponseElementDto get(Long id);

    List<ResponseElementDto> getAll(Long id);

    EquipmentElement getById(Long id);

    void addPartElement(Long id, PartElement partElement);

   void delete(Long id);
}