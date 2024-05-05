CREATE TABLE IF NOT EXISTS EQUIPMENT_TYPES
(
    id             BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    equipment_name VARCHAR                                 NOT NULL,
    model          VARCHAR,
    CONSTRAINT pk_equipmentType PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS EQUIPMENT_DIAGNOSED
(
    id                BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    equipment_type_id BIGINT                                  NOT NULL,
    building_id       BIGINT                                  NOT NULL,
    equipment_name    VARCHAR                                 NOT NULL,
    stationary_number INTEGER,
    model             VARCHAR,
    volume            INTEGER,
    equipment_full    BOOLEAN,
    old               BOOLEAN,
    CONSTRAINT pk_equipmentDiagnosed PRIMARY KEY (id),
    CONSTRAINT FK_EQUIPMENT_DIAGNOSED_ON_EQUIPMENT_TYPES FOREIGN KEY (equipment_type_id) REFERENCES equipment_types (id)
);

CREATE TABLE IF NOT EXISTS EQUIPMENT_PASSPORT
(
    id                     BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    equipment_diagnosed_id BIGINT                                  NOT NULL,
    sequential_number      INTEGER                                 NOT NULL,
    header                 VARCHAR                                 NOT NULL,
    meaning                VARCHAR                                 NOT NULL,
    use_to_protocol        BOOLEAN                                 NOT NULL,
    CONSTRAINT pk_equipmentPassport PRIMARY KEY (id),
    CONSTRAINT FK_EQUIPMENT_PASSPORT_ON_EQUIPMENT_DIAGNOSED
        FOREIGN KEY (equipment_diagnosed_id) REFERENCES equipment_diagnosed (id)
);

CREATE TABLE IF NOT EXISTS STANDARD_SIZES
(
    id               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    design_thickness DOUBLE PRECISION,
    outer_diameter   INTEGER,
    min_diameter     INTEGER,
    max_diameter     INTEGER,
    CONSTRAINT pk_standardSize PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS EQUIPMENT_ELEMENTS
(
    id                     BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    element_name           VARCHAR                                 NOT NULL,
    standard_size_id       BIGINT,
    equipment_diagnosed_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_equipmentElement PRIMARY KEY (id),
    CONSTRAINT FK_EQUIPMENT_ELEMENTS_ON_STANDARD_SIZES FOREIGN KEY (standard_size_id) REFERENCES standard_sizes (id),
    CONSTRAINT FK_EQUIPMENT_ELEMENTS_ON_EQUIPMENT_DIAGNOSED
        FOREIGN KEY (equipment_diagnosed_id) REFERENCES equipment_diagnosed (id)
);

CREATE TABLE IF NOT EXISTS PARTS_ELEMENTS
(
    id               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    part_name        VARCHAR                                 NOT NULL,
    element_id       BIGINT                                  NOT NULL,
    standard_size_id BIGINT,
    CONSTRAINT pk_partElement PRIMARY KEY (id),
    CONSTRAINT FK_PARTS_ELEMENTS_ON_STANDARD_SIZES FOREIGN KEY (standard_size_id) REFERENCES standard_sizes (id),
    CONSTRAINT FK_PARTS_ELEMENTS_ON_ELEMENTS FOREIGN KEY (element_id) REFERENCES equipment_elements (id)
);

CREATE TABLE IF NOT EXISTS ACCEPTABLE_DEVIATIONS_GEODESY
(
    id                                BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    equipment_type_id                 BIGINT                                  NOT NULL,
    fulls                             BOOLEAN                                 NOT NULL,
    old                               BOOLEAN                                 NOT NULL,
    volume                            INTEGER                                 NOT NULL,
    acceptable_precipitation          INTEGER                                 NOT NULL,
    max_difference_neighboring_points INTEGER                                 NOT NULL,
    max_difference_diametric_points   INTEGER                                 NOT NULL,
    measurement_error                 INTEGER                                 NOT NULL,
    number_locations                  INTEGER                                 NOT NULL,
    CONSTRAINT pk_permissibleDeviationsGeodesy PRIMARY KEY (id),
    CONSTRAINT UQ_PERMISSIBLE_DEVIATIONS_GEODESY UNIQUE (equipment_type_id, fulls, old, number_locations)
);

CREATE TABLE IF NOT EXISTS ACCEPTABLE_THICKNESS
(
    id                 BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    equipment_type_id  BIGINT                                  NOT NULL,
    element_id         BIGINT                                  NOT NULL,
    part_element_id    BIGINT,
    diameter           INTEGER,
    min_thickness      DOUBLE PRECISION,
    acceptable_percent INTEGER,
    measurement_error  FLOAT,
    CONSTRAINT pk_acceptableThickness PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ACCEPTABLE_HARDNESS
(
    id                     BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    equipment_type_id      BIGINT                                  NOT NULL,
    element_id             BIGINT                                  NOT NULL,
    min_allowable_diameter INTEGER                                 NOT NULL,
    min_hardness           INTEGER                                 NOT NULL,
    max_hardness           INTEGER                                 NOT NULL,
    measurement_error      FLOAT,
    CONSTRAINT pk_acceptableHardness PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS DEFECTS
(
    id                      BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    defect_name             VARCHAR                                 NOT NULL,
    not_meet_requirements   BOOLEAN                                 NOT NULL,
    actions_on_parameter    VARCHAR                                 NOT NULL,
    use_calculate_thickness BOOLEAN,
    CONSTRAINT pk_defect PRIMARY KEY (id),
    CONSTRAINT UQ_DEFECTS UNIQUE (defect_name)
);

CREATE TABLE IF NOT EXISTS ELEMENT_REPAIRS
(
    id                   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    repair_name          VARCHAR                                 NOT NULL,
    actions_on_parameter VARCHAR                                 NOT NULL,
    CONSTRAINT pk_elementRepair PRIMARY KEY (id),
    CONSTRAINT UQ_ELEMENT_REPAIRS UNIQUE (repair_name)
);

CREATE TABLE IF NOT EXISTS MEASUREMENTS_PARAMETERS
(
    id               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    parameter_name   VARCHAR                                 NOT NULL,
    unit_measurement VARCHAR                                 NOT NULL,
    defect_id        BIGINT,
    repair_id        BIGINT,
    CONSTRAINT pk_measuredParameter PRIMARY KEY (id),
    CONSTRAINT FK_MEASUREMENTS_PARAMETERS_ON_DEFECTS FOREIGN KEY (defect_id) REFERENCES defects (id),
    CONSTRAINT FK_MEASUREMENTS_PARAMETERS_ON_ELEMENT_REPAIRS FOREIGN KEY (repair_id) REFERENCES element_repairs (id)
);

CREATE TABLE IF NOT EXISTS EMPLOYEE_RECOMMENDATIONS
(
    id                  BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    equipment_id        BIGINT                                  NOT NULL,
    recommendation_text VARCHAR                                 NOT NULL,
    CONSTRAINT pk_employeeRecommendation PRIMARY KEY (id),
    CONSTRAINT UQ_EMPLOYEE_RECOMMENDATIONS UNIQUE (equipment_id, recommendation_text)
);

CREATE TABLE IF NOT EXISTS EQUIPMENT_INSPECTIONS
(
    id                     BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    equipment_diagnosed_id BIGINT                                  NOT NULL,
    date                   VARCHAR                                 NOT NULL,
    inspection             VARCHAR                                 NOT NULL,
    document_number        VARCHAR                                 NOT NULL,
    organization           VARCHAR                                 NOT NULL,
    CONSTRAINT pk_equipmentInspection PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS EQUIPMENT_REPAIRS
(
    id                     BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    equipment_diagnosed_id BIGINT                                  NOT NULL,
    date                   VARCHAR                                 NOT NULL,
    description            VARCHAR                                 NOT NULL,
    organization           VARCHAR,
    CONSTRAINT pk_equipmentRepair PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS DATA_EQUIPMENT_CALCULATIONS
(
    id                BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    survey_journal_id BIGINT                                  NOT NULL,
    equipment_type_id BIGINT                                  NOT NULL,
    equipment_id      BIGINT                                  NOT NULL,
    equipment_full    BOOLEAN,
    equipment_old     BOOLEAN,
    volume            INTEGER,
    model             VARCHAR,
    CONSTRAINT pk_dataOfEquipmentForCalculations PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS STANDARD_SIZES
(
    id               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    equipment_id     BIGINT                                  NOT NULL,
    element_id       BIGINT                                  NOT NULL,
    part_element_id  BIGINT,
    design_thickness DOUBLE PRECISION,
    outer_diameter   INTEGER,
    min_diameter     INTEGER,
    max_diameter     INTEGER,
    CONSTRAINT pk_standardSize PRIMARY KEY (id),
    CONSTRAINT FK_STANDARD_SIZES_ON_DATA_EQUIPMENT_CALCULATIONS
        FOREIGN KEY (equipment_id) REFERENCES data_equipment_calculations (id)
);

CREATE TABLE IF NOT EXISTS GEODESIC_MEASUREMENTS
(
    id                          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    survey_journal_id           BIGINT                                  NOT NULL,
    equipment_id                BIGINT                                  NOT NULL,
    sequential_number           INTEGER                                 NOT NULL,
    number_measurement_location INTEGER                                 NOT NULL,
    reference_point_value       INTEGER,
    control_point_value         INTEGER                                 NOT NULL,
    transition_value            INTEGER,
    CONSTRAINT pk_geodesicMeasurement PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS REFERENCE_POINTS
(
    id                       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    survey_journal_id        BIGINT                                  NOT NULL,
    equipment_id             BIGINT                                  NOT NULL,
    place_number             INTEGER                                 NOT NULL,
    calculated_height        INTEGER                                 NOT NULL,
    deviation                INTEGER                                 NOT NULL,
    precipitation            INTEGER,
    acceptable_precipitation BOOLEAN,
    result_measurement_id    BIGINT                                  NOT NULL,
    CONSTRAINT pk_referencePoint PRIMARY KEY (id),
    CONSTRAINT UQ_REFERENCE_POINTS UNIQUE (survey_journal_id, equipment_id, place_number)
);

CREATE TABLE IF NOT EXISTS DEVIATION_YEARS
(
    id                 BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    reference_point_id BIGINT                                  NOT NULL,
    year               INTEGER                                 NOT NULL,
    deviation          INTEGER                                 NOT NULL,
    CONSTRAINT pk_deviationYear PRIMARY KEY (id),
    CONSTRAINT UQ_DEVIATION_YEARS UNIQUE (reference_point_id, year),
    CONSTRAINT FK_DEVIATION_YEARS_ON_REFERENCE_POINTS FOREIGN KEY (reference_point_id) REFERENCES reference_points (id)
);

CREATE TABLE IF NOT EXISTS CONTROL_POINTS
(
    id                    BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    survey_journal_id     BIGINT                                  NOT NULL,
    equipment_id          BIGINT                                  NOT NULL,
    place_number          INTEGER                                 NOT NULL,
    calculated_height     INTEGER                                 NOT NULL,
    deviation             INTEGER                                 NOT NULL,
    measurement_id        BIGINT                                  NOT NULL,
    result_measurement_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_controlPoint PRIMARY KEY (id),
    CONSTRAINT UQ_CONTROL_POINTS UNIQUE (survey_journal_id, equipment_id, place_number)
);

CREATE TABLE IF NOT EXISTS POINTS_DIFFERENCE
(
    id                    BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    survey_journal_id     BIGINT                                  NOT NULL,
    equipment_id          BIGINT                                  NOT NULL,
    type                  VARCHAR                                 NOT NULL,
    first_place_number    INTEGER                                 NOT NULL,
    second_place_number   INTEGER                                 NOT NULL,
    difference            INTEGER                                 NOT NULL,
    acceptable_deviation  BOOLEAN,
    result_measurement_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_pointDifference PRIMARY KEY (id),
    CONSTRAINT UQ_POINTS_DIFFERENCE UNIQUE (survey_journal_id, equipment_id, first_place_number, second_place_number)
);

CREATE TABLE IF NOT EXISTS VISUAL_MEASURING_SURVEYS
(
    id                BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    survey_journal_id BIGINT                                  NOT NULL,
    equipment_id      BIGINT                                  NOT NULL,
    CONSTRAINT pk_visualMeasuringSurvey PRIMARY KEY (id)
);