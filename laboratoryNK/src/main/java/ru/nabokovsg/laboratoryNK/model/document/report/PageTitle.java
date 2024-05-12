package ru.nabokovsg.laboratoryNK.model.document.report;

import jakarta.persistence.*;
import lombok.*;
import ru.nabokovsg.laboratoryNK.model.document.DocumentHeader;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "page_title")
public class PageTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "pageTitle", fetch = FetchType.LAZY)
    private Set<DocumentHeader> documentHeaders;
    @Column(name = "title")
    private String title;
    @Column(name = "subtitle")
    private String subtitle;
    @Column(name = "equipment_text")
    private String equipmentText;
    @Column(name = "installation_location")
    private String installationLocation;
    @Column(name = "address")
    private String address;
    @Column(name = "number_date")
    private String numberAndDate;
    @Column(name = "post")
    private String post;
    @Column(name = "initials")
    private String initials;
    @Column(name = "city")
    private String city;
    @Column(name = "year")
    private String year;
}