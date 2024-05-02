package ru.nabokovsg.laboratoryNK.repository.template;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.template.MeasuringToolTemplate;

public interface MeasuringToolTemplateRepository extends JpaRepository<MeasuringToolTemplate, Long> {

    boolean existsByTollAndModel(String toll, String model);

    MeasuringToolTemplate findByMeasuringToolId(Long measuringToolId);
}