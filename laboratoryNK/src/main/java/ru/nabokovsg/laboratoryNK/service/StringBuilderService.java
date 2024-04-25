package ru.nabokovsg.laboratoryNK.service;

import ru.nabokovsg.laboratoryNK.dto.client.BuildingDto;
import ru.nabokovsg.laboratoryNK.dto.client.EmployeeDto;

public interface StringBuilderService {

    String buildInitials(EmployeeDto employee);

    String buildBuilding(BuildingDto building);
}