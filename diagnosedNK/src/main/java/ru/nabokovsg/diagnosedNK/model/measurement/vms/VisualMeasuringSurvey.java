package ru.nabokovsg.diagnosedNK.model.measurement.vms;

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
@Table(name = "visual_measuring_surveys")
public class VisualMeasuringSurvey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "survey_journal_id")
    private Long surveyJournalId;
    @Column(name = "equipment_id")
    private Long equipmentId;
    @OneToMany(mappedBy = "visualMeasuringSurvey", fetch = FetchType.LAZY)
    private Set<DefectMeasurement> defectMeasurements;
    @OneToMany(mappedBy = "visualMeasuringSurvey", fetch = FetchType.LAZY)
    private Set<CompletedRepairElement> completedRepairsElements;
    @OneToMany(mappedBy = "visualMeasuringSurvey", fetch = FetchType.LAZY)
    private Set<VisualInspection> visualInspections;
}