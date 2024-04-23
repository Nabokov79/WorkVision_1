package ru.nabokovsg.laboratoryNK.model.diagnosticDocument;

import java.util.Optional;

public enum TypeDocument {

    REPORT,
    INSPECTION_PROTOCOL,
    CONTROL_PROTOCOL;

    public static Optional<TypeDocument> from(String document) {
        for (TypeDocument type : values()) {
            if (type.name().equalsIgnoreCase(document)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }
}