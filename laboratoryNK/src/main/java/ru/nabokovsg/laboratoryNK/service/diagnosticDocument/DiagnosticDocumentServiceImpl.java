package ru.nabokovsg.laboratoryNK.service.diagnosticDocument;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.dto.tasksJournal.ResponseTasksJournalDto;
import ru.nabokovsg.laboratoryNK.exceptions.BadRequestException;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocument.DiagnosticDocument;
import ru.nabokovsg.laboratoryNK.repository.diagnosticDocument.DiagnosticDocumentRepository;

import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;

@Service
@RequiredArgsConstructor
public class DiagnosticDocumentServiceImpl implements DiagnosticDocumentService {

    private final DiagnosticDocumentRepository repository;

    @Override
    public void save(ResponseTasksJournalDto taskJournal) {
        if (taskJournal.getDate() != null) {

        }
    }

    @Override
    public void update(ResponseTasksJournalDto taskJournal) {
        DiagnosticDocument document = repository.findByTaskJournalId(taskJournal.getId());
        if (document != null) {

        } else {
            save(taskJournal);
        }
    }

    @Override
    public void existsByTaskJournalId(Long taskJournalId) {
        DiagnosticDocument document = repository.findByTaskJournalId(taskJournalId);
        if (document.getDocumentPath() != null) {
            throw new BadRequestException(
                    String.format("Document has been created for writing in the task log with number=%s", document.getDocumentNumber())
            );
        }
    }

    private Integer getDocumentNumber() {
        LocalDate now = LocalDate.now();
        LocalDate firstDay = now.with(firstDayOfYear());
        LocalDate lastDay = now.with(lastDayOfYear());
        QDocument document = QDocument.document;
        Integer number = new JPAQueryFactory(em).from(document)
                .select(document.documentNumber.max())
                .where(document.date.after(firstDay).and(document.date.before(lastDay)))
                .fetchOne();
        if (number == null) {
            return 1;
        }
        return (++number);
    }
}