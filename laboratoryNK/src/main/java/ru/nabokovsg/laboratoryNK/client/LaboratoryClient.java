package ru.nabokovsg.laboratoryNK.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.dto.client.BranchDto;
import ru.nabokovsg.laboratoryNK.dto.client.EmployeeDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaboratoryClient {

    private final CompanyClient companyClient;
    private static final String DELIMITER = "/";
    private static final String API_PREFIX_EMPLOYEE = "/employee";
    private static final String API_PREFIX_BRANCH = "/branch";

    public List<EmployeeDto> getAllEmployees(Long id, String divisionType) {
        return companyClient.getAllEmployees(String.join(DELIMITER, API_PREFIX_EMPLOYEE,
                "all", String.valueOf(id)), "divisionType", divisionType);
    }

    public BranchDto getBranch(Long id) {
        return companyClient.getBranch(String.join(DELIMITER,API_PREFIX_BRANCH, String.valueOf(id)));
    }
}