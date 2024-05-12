package ru.nabokovsg.laboratoryNK.model.document.protocol;

import jakarta.persistence.*;
import lombok.*;
import ru.nabokovsg.laboratoryNK.model.document.DocumentHeader;
import ru.nabokovsg.laboratoryNK.model.document.DocumentTable;
import ru.nabokovsg.laboratoryNK.model.document.Subsection;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "protocol_control")
public class ProtocolControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "equipment_diagnosed_id")
    private Long equipmentDiagnosedId;
    @Column(name = "survey_journal_id")
    private Long surveyJournalId;
    @OneToMany(mappedBy = "protocolControl", fetch = FetchType.LAZY)
    private Set<DocumentHeader> leftHeader;
    @OneToOne
    @JoinColumn(name = "work_place_id", referencedColumnName = "id")
    private Workplace workPlace;
    @Column(name = "title")
    private String title;
    @Column(name = "subtitle")
    private String subtitle;
    @OneToMany(mappedBy = "protocolControl", fetch = FetchType.LAZY)
    private Set<Subsection> subsections;
    @OneToMany(mappedBy = "protocolControl", fetch = FetchType.LAZY)
    private Set<DocumentTable> tables;
}