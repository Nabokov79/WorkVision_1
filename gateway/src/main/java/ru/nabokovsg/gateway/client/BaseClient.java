package ru.nabokovsg.gateway.client;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.nabokovsg.gateway.exceptions.NotFoundException;

@AllArgsConstructor
public class BaseClient {

    private final WebClient client;

    public <T> Mono<Object> post(String path, T body) {
        return client.post()
                .uri(path)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(Object.class);
    }

    public <T> Mono<Object> patch(String path, T body) {
        return client.patch()
                .uri(path)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(Object.class);
    }

    public Mono<Object> get(String path) {
        return client.get()
                .uri(path)
                .retrieve()
                .bodyToMono(Object.class);
    }

    public Mono<Object> get(String path, String paramName, String param) {
        return client.get()
                .uri(uriBuilder -> uriBuilder.path(path)
                        .queryParam(paramName, param)
                        .build())
                .retrieve()
                .bodyToMono(Object.class);
    }

    public Flux<Object> getAll(String path) {
        return client.get()
                .uri(path)
                .retrieve()
                .bodyToFlux(Object.class);
    }

    public Flux<Object> getAll(String path, String paramName, String param) {
        return client.get()
                .uri(uriBuilder -> uriBuilder.path(path)
                                                .queryParam(paramName, param)
                                                .build())
                .retrieve()
                .bodyToFlux(Object.class);
    }

    public Flux<Object> getAll(String path, MultiValueMap<String, String> params) {
        return client.get()
                .uri(uriBuilder -> uriBuilder.path(path)
                        .queryParams(params)
                        .build())
                .retrieve()
                .bodyToFlux(Object.class);
    }

    public Flux<Object> getAll(String path, String firstParamName, String firstParam
            , String secondParamName, String secondParam) {
        return client.get()
                .uri(uriBuilder -> uriBuilder.path(path)
                        .queryParam(firstParamName, firstParam)
                        .queryParam(secondParamName, secondParam)
                        .build())
                .retrieve()
                .bodyToFlux(Object.class);
    }

    public Mono<String> delete(String path) {
        return client.delete()
                .uri(path)
                .retrieve()
                .onStatus(status -> status == HttpStatus.NOT_FOUND
                        , clientResponse -> Mono.just(
                                new NotFoundException(
                                        String.format("Object by path=%s not found for delete",  path))))
                .bodyToMono(String.class);
    }
}
