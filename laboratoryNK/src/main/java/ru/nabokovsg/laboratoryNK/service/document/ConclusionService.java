package ru.nabokovsg.laboratoryNK.service.document;

import ru.nabokovsg.laboratoryNK.model.document.Conclusion;
import ru.nabokovsg.laboratoryNK.model.template.ConclusionTemplate;

public interface ConclusionService {

    Conclusion save(ConclusionTemplate template);
}