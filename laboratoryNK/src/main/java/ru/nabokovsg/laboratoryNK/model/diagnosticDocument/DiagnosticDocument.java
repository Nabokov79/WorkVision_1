package ru.nabokovsg.laboratoryNK.model.diagnosticDocument;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "diagnostic_documents")
public class DiagnosticDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "task_journal_id")
    private Long taskJournalId;
    @Column(name = "equipment_diagnosed_id")
    private String equipmentDiagnosedId;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type_id",  nullable = false)
    private DocumentType documentType;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "next_date")
    private LocalDate nextDate;
    @Column(name = "document_number")
    private Integer documentNumber;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private DocumentStatus status;
    @Column(name = "document_path")
    private String documentPath;
    @Column(name = "drawing_path")
    private String drawingPath;
}