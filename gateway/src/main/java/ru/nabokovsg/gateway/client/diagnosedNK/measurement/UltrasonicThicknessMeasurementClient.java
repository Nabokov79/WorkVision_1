package ru.nabokovsg.gateway.client.diagnosedNK.measurement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.nabokovsg.gateway.client.BaseClient;
import ru.nabokovsg.gateway.dto.diagnosedNK.measurement.utm.NewUltrasonicThicknessMeasurementDto;
import ru.nabokovsg.gateway.dto.diagnosedNK.measurement.utm.UpdateUltrasonicThicknessMeasurementDto;

@Service
public class UltrasonicThicknessMeasurementClient extends BaseClient {

    private static final String API_PREFIX = "/measurement/ultrasonic-thickness";
    private static final String DELIMITER = "/";

    @Autowired
    public UltrasonicThicknessMeasurementClient(@Value("${diagnosedNK-server.url}") String baseUrl) {
        super(WebClient.builder()
                .baseUrl(baseUrl)
                .build());
    }

    public Mono<Object> save(NewUltrasonicThicknessMeasurementDto measurementDto) {
        return post(API_PREFIX, measurementDto);
    }

    public Mono<Object> update(UpdateUltrasonicThicknessMeasurementDto measurementDto) {
        return patch(API_PREFIX, measurementDto);
    }

    public Flux<Object> getAll(Long id) {
        return getAll(String.join(DELIMITER, API_PREFIX, "all", String.valueOf(id)));
    }

    public Mono<String> delete(Long id) {
        return delete(String.join(DELIMITER, API_PREFIX, String.valueOf(id)));
    }
}