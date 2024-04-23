package ru.nabokovsg.company.model;

import jakarta.persistence.*;
import lombok.*;
import ru.nabokovsg.company.model.enums.DivisionType;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "heat_supply_areas")
public class HeatSupplyArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "division_type")
    @Enumerated(EnumType.STRING)
    private DivisionType divisionType;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "short_name")
    private String shortName;
    @OneToMany(mappedBy = "heatSupplyArea", fetch = FetchType.LAZY)
    private List<ExploitationRegion> exploitationRegions;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id",  nullable = false)
    private Branch branch;
}