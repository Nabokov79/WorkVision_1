package ru.nabokovsg.laboratoryNK.model.template.report;

import jakarta.persistence.*;
import lombok.*;
import ru.nabokovsg.laboratoryNK.model.template.DocumentHeaderTemplate;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "page_title_templates")
public class PageTitleTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "page_title_templates_document_headers",
            joinColumns = {@JoinColumn(name = "page_title_template_id")},
            inverseJoinColumns = {@JoinColumn(name = "document_header_id")})
    @ToString.Exclude
    private Set<DocumentHeaderTemplate> documentHeaders;
    @Column(name = "title")
    private String title;
    @Column(name = "subtitle")
    private String subtitle;
    @Column(name = "equipment_text")
    private String equipmentText;
    @Column(name = "installation_location")
    private String installationLocation;
    @Column(name = "city")
    private String city;
}