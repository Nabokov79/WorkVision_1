package ru.nabokovsg.laboratoryNK.model.diagnosticDocument;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "remarks")
public class Remark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "remark")
    private String remark;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id",  nullable = false)
    private DiagnosticDocumentType document;
}