package ru.nabokovsg.diagnosedNK.model.measurement;

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
@Table(name = "hardness_measurements")
public class HardnessMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "survey_journal_id")
    private Long surveyJournalId;
    @Column(name = "equipment_id")
    private Long equipmentId;
    @Column(name = "element_id")
    private Long elementId;
    @Column(name = "part_element_id")
    private Long partElementId;
    @Column(name = "measurement_number")
    private Integer measurementNumber;
    @Column(name = "diameter")
    private Integer diameter;
    @Column(name = "measurement_value")
    private Integer measurementValue;
    @Column(name = "acceptable_value")
    private Boolean acceptableValue;
}