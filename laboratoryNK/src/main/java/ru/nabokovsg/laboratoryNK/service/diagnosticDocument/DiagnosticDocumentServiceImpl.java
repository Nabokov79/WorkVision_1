package ru.nabokovsg.laboratoryNK.service.diagnosticDocument;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.repository.diagnosticDocument.DiagnosticDocumentRepository;

@Service
@RequiredArgsConstructor
public class DiagnosticDocumentServiceImpl implements DiagnosticDocumentService {

    private final DiagnosticDocumentRepository repository;
}