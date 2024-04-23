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
@Table(name = "document_types")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "heading")
    private String heading;
    @Column(name = "type_document")
    @Enumerated(EnumType.STRING)
    private TypeDocument typeDocument;
}