package ru.nabokovsg.laboratoryNK.model.equipmentDiagnosed;

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
@Table(name = "standard_sizes")
public class StandardSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "design_thickness")
    private Double designThickness;
    @Column(name = "outer_diameter")
    private Integer outerDiameter;
    @Column(name = "min_diameter")
    private Integer minDiameter;
    @Column(name = "max_diameter")
    private Integer maxDiameter;
}