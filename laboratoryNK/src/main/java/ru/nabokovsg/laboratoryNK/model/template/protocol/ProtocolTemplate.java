package ru.nabokovsg.laboratoryNK.model.template.protocol;

import jakarta.persistence.*;
import lombok.*;
import ru.nabokovsg.laboratoryNK.model.template.ConclusionTemplate;
import ru.nabokovsg.laboratoryNK.model.template.Appendices;
import ru.nabokovsg.laboratoryNK.model.template.DocumentHeader;
import ru.nabokovsg.laboratoryNK.model.template.SubsectionTemplate;
import ru.nabokovsg.laboratoryNK.model.template.TableTemplate;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "protocol_templates")
public class ProtocolTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "document_type_id")
    private Long documentTypeId;
    @Column(name = "equipment_type_id")
    private Long equipmentTypeId;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "protocol_templates_document_headers",
            joinColumns = {@JoinColumn(name = "protocol_template_id")},
            inverseJoinColumns = {@JoinColumn(name = "document_header_id")})
    @ToString.Exclude
    private Set<DocumentHeader> leftHeaderTemplates;
    @Column(name = "title")
    private String title;
    @Column(name = "subtitle")
    private String subtitle;
    @OneToMany(mappedBy = "protocolTemplate", fetch = FetchType.LAZY)
    private Set<SubsectionTemplate> subsectionTemplates;
    @OneToMany(mappedBy = "protocolTemplate", fetch = FetchType.LAZY)
    private Set<TableTemplate> tableTemplates;
    @OneToOne
    @JoinColumn(name = "conclusion_template_id", referencedColumnName = "id")
    private ConclusionTemplate conclusionTemplate;
    @OneToMany(mappedBy = "reportTemplate", fetch = FetchType.LAZY)
    private Set<Appendices> appendices;
}