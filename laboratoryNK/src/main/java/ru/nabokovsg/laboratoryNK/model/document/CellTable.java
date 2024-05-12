package ru.nabokovsg.laboratoryNK.model.document;

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
@Table(name = "cells_table")
public class CellTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "column_number")
    private Integer columnSequentialNumber;
    @Column(name = "string_number")
    private Integer stringSequentialNumber;
    @Column(name = "cell_value")
    private Integer cellValue;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id")
    private DocumentTable table;
}
