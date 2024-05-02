package ru.nabokovsg.laboratoryNK.model.template;

import java.util.Optional;

public enum SubsectionDataType {

    TABLE,
    DOCUMENTATION,
    MEASURING_TOOL;

    public static Optional<SubsectionDataType> from(String dataType) {
        for (SubsectionDataType type : values()) {
            if (type.name().equalsIgnoreCase(dataType)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }
}