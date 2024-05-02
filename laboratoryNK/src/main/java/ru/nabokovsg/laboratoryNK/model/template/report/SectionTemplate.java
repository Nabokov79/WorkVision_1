package ru.nabokovsg.laboratoryNK.model.template.report;

import jakarta.persistence.*;
import lombok.*;
import ru.nabokovsg.laboratoryNK.model.template.SubsectionTemplate;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "section_templates")
public class SectionTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sequential_number")
    private Integer sequentialNumber;
    @Column(name = "section_name")
    private String sectionName;
    @OneToMany(mappedBy = "sectionTemplate", fetch = FetchType.LAZY)
    private Set<SubsectionTemplate> subsectionTemplates;
    @OneToMany(mappedBy = "sectionTemplate", fetch = FetchType.LAZY)
    private Set<ProtocolReportTemplate> protocolReportTemplates;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "report_template_id",  nullable = false)
    private ReportTemplate reportTemplate;
}