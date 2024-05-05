package ru.nabokovsg.diagnosedNK.model.measurement.vms;

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
@Table(name = "parameters_measurements")
public class ParameterMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "parameter_name")
    private String parameterName;
    @Column(name = "parameters_value")
    private Double parameterValue;
    @Column(name = "min_value")
    private Double minValue;
    @Column(name = "max_value")
    private Double maxValue;
    @Column(name = "unit_measurement")
    private String unitMeasurement;
    @Column(name = "use_calculate_thickness")
    private Boolean useCalculateThickness;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "defect_measurement_id",  nullable = false)
    private DefectMeasurement defectMeasurement;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "completed_repair_id",  nullable = false)
    private CompletedRepairElement completedRepairElement;
}
