package ru.nabokovsg.gateway.client.diagnosedNK.measurement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.nabokovsg.gateway.client.BaseClient;
import ru.nabokovsg.gateway.dto.diagnosedNK.measurement.vms.completedRepairElement.NewCompletedRepairElementDto;
import ru.nabokovsg.gateway.dto.diagnosedNK.measurement.vms.completedRepairElement.UpdateCompletedRepairElementDto;

@Service
public class CompletedRepairElementClient extends BaseClient {

    private static final String API_PREFIX = "/measurement/repair";
    private static final String DELIMITER = "/";

    @Autowired
    public CompletedRepairElementClient(@Value("${diagnosedNK-server.url}") String baseUrl) {
        super(WebClient.builder()
                .baseUrl(baseUrl)
                .build());
    }

    public Mono<Object> save(NewCompletedRepairElementDto repairDto) {
        return post(API_PREFIX, repairDto);
    }

    public Mono<Object> update(UpdateCompletedRepairElementDto repairDto) {
        return patch(API_PREFIX, repairDto);
    }

    public Flux<Object> getAll(Long id) {
        return getAll(String.join(DELIMITER, API_PREFIX, String.valueOf(id)));
    }

    public Mono<String> delete(Long id) {
        return delete(String.join(DELIMITER, API_PREFIX, String.valueOf(id)));
    }
}