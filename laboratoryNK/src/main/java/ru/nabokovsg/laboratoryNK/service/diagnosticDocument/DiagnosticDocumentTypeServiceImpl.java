package ru.nabokovsg.laboratoryNK.service.diagnosticDocument;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.dto.diagnosticDocument.DiagnosticDocumentTypeDto;
import ru.nabokovsg.laboratoryNK.exceptions.BadRequestException;
import ru.nabokovsg.laboratoryNK.exceptions.NotFoundException;
import ru.nabokovsg.laboratoryNK.mapper.diagnosticDocument.DiagnosticDocumentTypeMapper;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocument.DiagnosticDocumentType;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocument.TypeDocument;
import ru.nabokovsg.laboratoryNK.repository.diagnosticDocument.DiagnosticDocumentTypeRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DiagnosticDocumentTypeServiceImpl implements DiagnosticDocumentTypeService {

    private final DiagnosticDocumentTypeRepository repository;
    private final DiagnosticDocumentTypeMapper mapper;

    @Override
    public DiagnosticDocumentTypeDto save(DiagnosticDocumentTypeDto documentTypeDto) {
        TypeDocument typeDocument = convertToTypeDocument(documentTypeDto.getTypeDocument());
        return mapper.mapToDiagnosticDocumentTypeDto(
                Objects.requireNonNullElseGet(
                        repository.findByTitleAndHeadingAndTypeDocument(documentTypeDto.getTitle()
                                , documentTypeDto.getHeading()
                                , typeDocument)
                        , () -> repository.save(mapper.mapToDiagnosticDocument(documentTypeDto, typeDocument)))
        );
    }

    @Override
    public DiagnosticDocumentTypeDto update(DiagnosticDocumentTypeDto documentTypeDto) {
        if (repository.existsById(documentTypeDto.getId())) {
            return mapper.mapToDiagnosticDocumentTypeDto(
                    repository.save(mapper.mapToDiagnosticDocument(documentTypeDto
                                                            , convertToTypeDocument(documentTypeDto.getTypeDocument())))
            );
        }
        throw new NotFoundException(
                String.format("Diagnostic document type with id = %s not found for update", documentTypeDto.getId())
        );
    }

    @Override
    public List<DiagnosticDocumentTypeDto> getAll() {
        return repository.findAll()
                         .stream()
                         .map(mapper::mapToDiagnosticDocumentTypeDto)
                         .toList();
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("Diagnostic document type with id = %s not found for delete", id));
    }

    @Override
    public DiagnosticDocumentType getById(Long diagnosticDocumentTypeId) {
        return repository.findById(diagnosticDocumentTypeId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Diagnostic document type with id=%s not found", diagnosticDocumentTypeId))
                );
    }

    private TypeDocument convertToTypeDocument(String typeDocument) {
        return TypeDocument.from(typeDocument)
                .orElseThrow(() -> new BadRequestException(String.format("Unknown type=%s", typeDocument)));
    }
}