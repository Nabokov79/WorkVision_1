package ru.nabokovsg.laboratoryNK.model.template;

import jakarta.persistence.*;
import lombok.*;
import ru.nabokovsg.laboratoryNK.model.template.protocol.ProtocolControlTemplate;
import ru.nabokovsg.laboratoryNK.model.template.protocol.ProtocolTemplate;
import ru.nabokovsg.laboratoryNK.model.template.report.ProtocolReportTemplate;
import ru.nabokovsg.laboratoryNK.model.template.report.SectionTemplate;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subsection_templates")
public class SubsectionTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sequential_number")
    private Integer sequentialNumber;
    @Column(name = "subsection_name")
    private String subsectionName;
    @Column(name = "user_text")
    private String userText;
    @Column(name = "division")
    private String division;
    @OneToOne
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private TableTemplate tableTemplate;
    @OneToMany(mappedBy = "subsectionTemplate", fetch = FetchType.LAZY)
    private List<RegulatoryDocumentationTemplate> documentationTemplate;
    @OneToMany(mappedBy = "subsectionTemplate", fetch = FetchType.LAZY)
    private List<MeasuringToolTemplate> measuringToolsTemplates;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "protocol_report_template_id")
    private ProtocolReportTemplate protocolReportTemplate;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "section_template_id")
    private SectionTemplate sectionTemplate;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "protocol_template_id")
    private ProtocolTemplate protocolTemplate;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "protocol_control_template_id")
    private ProtocolControlTemplate protocolControlTemplate;
}