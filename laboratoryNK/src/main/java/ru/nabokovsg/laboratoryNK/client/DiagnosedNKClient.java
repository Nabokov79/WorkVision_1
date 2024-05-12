package ru.nabokovsg.laboratoryNK.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.nabokovsg.laboratoryNK.dto.client.EquipmentPassportDto;
import ru.nabokovsg.laboratoryNK.dto.equipmentDiagnosed.EquipmentDto;

import java.util.List;

@Component
public class DiagnosedNKClient {

    private final WebClient client;

    @Autowired
    public DiagnosedNKClient(@Qualifier(value = "webDiagnosedNK") WebClient client) {
        this.client = client;
    }

    public EquipmentDto getEquipmentDiagnosedDto(String path) {
        return client.get()
                .uri(path)
                .retrieve()
                .bodyToMono(EquipmentDto.class)
                .block();
    }

    public List<EquipmentPassportDto> getEquipmentPassportDto(String path) {
        return client.get()
                .uri(path)
                .retrieve()
                .bodyToFlux(EquipmentPassportDto.class)
                .buffer()
                .blockFirst();
    }
}
