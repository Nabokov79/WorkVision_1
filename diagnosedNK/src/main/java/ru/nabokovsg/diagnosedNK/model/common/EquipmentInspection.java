package ru.nabokovsg.diagnosedNK.model.common;

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
@Table(name = "equipment_inspections")
public class EquipmentInspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date")
    private String date;
    @Column(name = "inspection")
    private String inspection;
    @Column(name = "document_number")
    private String documentNumber;
    @Column(name = "organization")
    private String organization;
    @Column(name = "equipment_diagnosed_id")
    private Long equipmentDiagnosedId;
}