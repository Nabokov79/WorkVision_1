package ru.nabokovsg.gateway.client.laboratoryNK.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.nabokovsg.gateway.client.BaseClient;
import ru.nabokovsg.gateway.dto.laboratoryNK.report.section.NewSectionWithProtocolTemplateDto;
import ru.nabokovsg.gateway.dto.laboratoryNK.report.section.NewSectionWithSubsectionTemplateDto;
import ru.nabokovsg.gateway.dto.laboratoryNK.report.section.UpdateSectionWithProtocolTemplateDto;
import ru.nabokovsg.gateway.dto.laboratoryNK.report.section.UpdateSectionWithSubsectionTemplateDto;

@Service
public class SectionTemplateClient extends BaseClient {

    private static final String API_PREFIX = "/template/section";
    private static final String DELIMITER = "/";

    @Autowired
    public SectionTemplateClient(@Value("${laboratoryNK-server.url}") String baseUrl) {
        super(WebClient.builder()
                .baseUrl(baseUrl)
                .build());
    }

    public Mono<Object> saveWithSubsection(NewSectionWithSubsectionTemplateDto sectionDto) {
        return post(API_PREFIX, sectionDto);
    }

    public Mono<Object> updateWithSubsection(UpdateSectionWithSubsectionTemplateDto sectionDto) {
        return patch(API_PREFIX, sectionDto);
    }

    public Mono<Object> saveWithProtocol(NewSectionWithProtocolTemplateDto sectionDto) {
        return post(API_PREFIX, sectionDto);
    }

    public Mono<Object> updateWithProtocol(UpdateSectionWithProtocolTemplateDto sectionDto) {
        return patch(API_PREFIX, sectionDto);
    }

    public Mono<Object> get(Long id) {
        return get(String.join(DELIMITER, API_PREFIX, String.valueOf(id)));
    }

    public Flux<Object> getAll(Long id) {
        return getAll(String.join(DELIMITER, API_PREFIX, "/all/report/", String.valueOf(id)));
    }

    public Mono<String> delete(Long id) {
        return delete(String.join(DELIMITER, API_PREFIX, String.valueOf(id)));
    }
}