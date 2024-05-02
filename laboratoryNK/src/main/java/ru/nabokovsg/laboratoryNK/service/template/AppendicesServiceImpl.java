package ru.nabokovsg.laboratoryNK.service.template;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.exceptions.NotFoundException;
import ru.nabokovsg.laboratoryNK.mapper.template.AppendicesMapper;
import ru.nabokovsg.laboratoryNK.repository.template.AppendicesRepository;
import ru.nabokovsg.laboratoryNK.dto.template.appendices.AppendicesDto;
import ru.nabokovsg.laboratoryNK.dto.template.appendices.ResponseAppendicesDto;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AppendicesServiceImpl implements AppendicesService {

    private final AppendicesRepository repository;
    private final AppendicesMapper mapper;
    private final static String NAME_OF_LIST = "Приложения";

    @Override
    public ResponseAppendicesDto save(AppendicesDto appendicesDto) {
        return mapper.mapToResponseAppendicesDto(
                Objects.requireNonNullElseGet(repository.findByAppendicesName(appendicesDto.getAppendicesName())
                        , () -> repository.save(mapper.mapToAppendicesTemplate(appendicesDto, NAME_OF_LIST))));
    }

    @Override
    public ResponseAppendicesDto update(AppendicesDto appendicesDto) {
        if (repository.existsById(appendicesDto.getId())) {
            return mapper.mapToResponseAppendicesDto(
                          repository.save(mapper.mapToAppendicesTemplate(appendicesDto, NAME_OF_LIST)));
        }
        throw new NotFoundException(
                String.format("Appendices template with id=%s not found for update", appendicesDto.getId())
        );
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw  new NotFoundException(String.format("Appendices template with id=%s not found for delete", id));
    }
}