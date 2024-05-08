package ru.nabokovsg.diagnosedNK.model.norms;

import java.util.Optional;

public enum ActionsOnParameter {

    MAX,
    MIN,
    MAX_MIN,
    QUANTITY,
    SQUARE,
    REPLACE,
    NO_ACTION;

    public static Optional<ActionsOnParameter> from(String action) {
        for (ActionsOnParameter type : values()) {
            if (type.name().equalsIgnoreCase(action)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }
}