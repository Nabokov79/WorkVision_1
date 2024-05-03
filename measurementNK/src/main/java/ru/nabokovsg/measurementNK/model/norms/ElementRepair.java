package ru.nabokovsg.measurementNK.model.norms;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "element_repairs")
public class ElementRepair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "repair_name")
    private String repairName;
    @Column(name = "actions_on_parameter")
    @Enumerated(EnumType.STRING)
    private ActionsOnParameter actionsOnParameter;
    @OneToMany(mappedBy = "elementRepair", fetch = FetchType.LAZY)
    private Set<MeasuredParameter> measuredParameters;
}