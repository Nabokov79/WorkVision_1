package ru.nabokovsg.laboratoryNK.model.template;

import jakarta.persistence.*;
import lombok.*;
import ru.nabokovsg.laboratoryNK.model.template.protocol.ProtocolControlTemplate;
import ru.nabokovsg.laboratoryNK.model.template.protocol.ProtocolTemplate;
import ru.nabokovsg.laboratoryNK.model.template.report.ProtocolReportTemplate;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "table_templates")
public class TableTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sequential_number")
    private Integer sequentialNumber;
    @Column(name = "table_name")
    private String tableName;
    @Column(name = "text_before_table")
    private String textBeforeTable;
    @Column(name = "text_after_table")
    private String textAfterTable;
    @OneToMany(mappedBy = "tableTemplate", fetch = FetchType.LAZY)
    private Set<ColumnHeaderTemplate> columnHeaders;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "protocol_report_template_id")
    private ProtocolReportTemplate protocolReportTemplate;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "protocol_template_id")
    private ProtocolTemplate protocolTemplate;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "protocol_control_template_id")
    private ProtocolControlTemplate protocolControlTemplate;
}