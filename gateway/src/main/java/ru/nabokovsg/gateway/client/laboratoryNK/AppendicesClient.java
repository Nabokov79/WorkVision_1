package ru.nabokovsg.gateway.client.laboratoryNK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.nabokovsg.gateway.client.BaseClient;
import ru.nabokovsg.gateway.dto.laboratoryNK.appendices.NewAppendicesDto;
import ru.nabokovsg.gateway.dto.laboratoryNK.appendices.UpdateAppendicesDto;

@Service
public class AppendicesClient extends BaseClient {

    private static final String API_PREFIX = "/appendices";
    private static final String DELIMITER = "/";

    @Autowired
    public AppendicesClient(@Value("${laboratoryNK-server.url}") String baseUrl) {
        super(WebClient.builder()
                .baseUrl(baseUrl)
                .build());
    }

    public Mono<Object> save(NewAppendicesDto appendicesDto) {
        return post(API_PREFIX, appendicesDto);
    }

    public Mono<Object> update(UpdateAppendicesDto appendicesDto) {
        return patch(API_PREFIX, appendicesDto);
    }

    public Mono<String> delete(Long id){
        return delete(String.join(DELIMITER, API_PREFIX, String.valueOf(id)));
    }
}
