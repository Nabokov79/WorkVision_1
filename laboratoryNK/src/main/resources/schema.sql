CREATE TABLE IF NOT EXISTS LABORATORY_EMPLOYEES
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    employee_id BIGINT                                  NOT NULL,
    post        VARCHAR                                 NOT NULL,
    initials    VARCHAR                                 NOT NULL,
    CONSTRAINT pk_laboratoryEmployee PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS EMPLOYEE_CERTIFICATES
(
    id                 BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    document_type      VARCHAR                                 NOT NULL,
    certificate_number VARCHAR                                 NOT NULL,
    control_type       VARCHAR                                 NOT NULL,
    level              VARCHAR                                 NOT NULL,
    start_date         DATE                                    NOT NULL,
    end_date           DATE                                    NOT NULL,
    points             VARCHAR                                 NOT NULL,
    organization       VARCHAR                                 NOT NULL,
    employee_id        BIGINT                                  NOT NULL,
    CONSTRAINT pk_employeeCertificate PRIMARY KEY (id),
    CONSTRAINT UQ_EMPLOYEE_CERTIFICATES UNIQUE (control_type, employee_id),
    CONSTRAINT FK_EMPLOYEE_CERTIFICATES_ON_LABORATORY_EMPLOYEES
        FOREIGN KEY (employee_id) REFERENCES laboratory_employees (id)
);

CREATE TABLE IF NOT EXISTS TASKS_JOURNALS
(
    id                  BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    date                DATE                                    NOT NULL,
    branch              VARCHAR                                 NOT NULL,
    heat_supply_area    VARCHAR,
    exploitation_region VARCHAR,
    building            VARCHAR                                 NOT NULL,
    equipment_id        BIGINT                                  NOT NULL,
    equipment_diagnosed VARCHAR                                 NOT NULL,
    work_type           VARCHAR                                 NOT NULL,
    task_source         VARCHAR,
    comment             VARCHAR,
    chief_id            BIGINT                                  NOT NULL,
    CONSTRAINT pk_tasksJournal PRIMARY KEY (id),
    CONSTRAINT FK_TASKS_JOURNAL_ON_LABORATORY_EMPLOYEES FOREIGN KEY (chief_id) REFERENCES laboratory_employees (id)
);

CREATE TABLE IF NOT EXISTS JOURNAL_EMPLOYEES
(
    journal_id  BIGINT,
    employee_id BIGINT,
    CONSTRAINT pk_tasks_journal_of_laboratory_employees PRIMARY KEY (journal_id, employee_id)
);

CREATE TABLE IF NOT EXISTS MEASURING_TOOLS
(
    id                     BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    toll                   VARCHAR                                 NOT NULL,
    model                  VARCHAR                                 NOT NULL,
    work_number            VARCHAR,
    purpose                VARCHAR,
    manufacturing          DATE,
    exploitation           DATE,
    manufacturer           VARCHAR,
    measuring_range        VARCHAR,
    characteristics        VARCHAR,
    owner                  VARCHAR                                 NOT NULL,
    verification_date      DATE,
    next_verification_date DATE,
    organization           VARCHAR,
    certificate_number     VARCHAR,
    registry               VARCHAR,
    note                   VARCHAR,
    control_type           VARCHAR                                 NOT NULL,
    laboratory_employee_id BIGINT,
    CONSTRAINT pk_measuringTool PRIMARY KEY (id),
    CONSTRAINT UQ_MEASURING_TOOL UNIQUE (toll, model, work_number)
);

CREATE TABLE IF NOT EXISTS DOCUMENTATIONS
(
    id     BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    view   VARCHAR,
    number VARCHAR,
    title  VARCHAR                                 NOT NULL,
    path   VARCHAR,
    CONSTRAINT pk_documentation PRIMARY KEY (id),
    CONSTRAINT UQ_DOCUMENTATIONS UNIQUE (title)
);

CREATE TABLE IF NOT EXISTS LABORATORY_CERTIFICATES
(
    id             BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    document_type  VARCHAR                                 NOT NULL,
    license_number VARCHAR                                 NOT NULL,
    start_date     DATE                                    NOT NULL,
    end_date       DATE                                    NOT NULL,
    organization   VARCHAR                                 NOT NULL,
    CONSTRAINT pk_laboratoryCertificate PRIMARY KEY (id),
    CONSTRAINT UQ_LABORATORY_CERTIFICATES UNIQUE (document_type, license_number, start_date, end_date)
);

CREATE TABLE IF NOT EXISTS DIAGNOSTIC_DOCUMENT_TYPES
(
    id            BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    title         VARCHAR                                 NOT NULL,
    heading       VARCHAR                                 NOT NULL,
    type_document VARCHAR                                 NOT NULL,
    CONSTRAINT pk_diagnosticDocumentType PRIMARY KEY (id),
    CONSTRAINT UQ_DIAGNOSTIC_DOCUMENT_TYPES UNIQUE (title, heading, type_document)
);

CREATE TABLE IF NOT EXISTS DIAGNOSTIC_DOCUMENTS
(
    id                          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    task_journal_id             BIGINT                                  NOT NULL,
    equipment_diagnosed_id      BIGINT                                  NOT NULL,
    diagnostic_document_type_id BIGINT                                  NOT NULL,
    date                        DATE                                    NOT NULL,
    next_date                   DATE,
    document_number             INTEGER                                 NOT NULL,
    status                      VARCHAR,
    document_path               VARCHAR,
    drawing_path                VARCHAR,
    CONSTRAINT pk_diagnosticDocument PRIMARY KEY (id),
    CONSTRAINT UQ_DIAGNOSTIC_DOCUMENT UNIQUE (equipment_diagnosed_id, date),
    CONSTRAINT FK_DIAGNOSTIC_DOCUMENT_ON_DIAGNOSTIC_DOCUMENT_TYPES
        FOREIGN KEY (diagnostic_document_type_id) REFERENCES diagnostic_document_types (id)
);

CREATE TABLE IF NOT EXISTS REMARKS
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    remark      VARCHAR                                 NOT NULL,
    document_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_remark PRIMARY KEY (id),
    CONSTRAINT FK_REMARKS_ON_DIAGNOSTIC_DOCUMENTS FOREIGN KEY (document_id) REFERENCES diagnostic_documents (id)
);

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