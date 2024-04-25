package ru.nabokovsg.laboratoryNK.service;

import org.springframework.stereotype.Component;
import ru.nabokovsg.laboratoryNK.dto.client.AddressDto;
import ru.nabokovsg.laboratoryNK.dto.client.BuildingDto;
import ru.nabokovsg.laboratoryNK.dto.client.EmployeeDto;

@Component
public class StringBuilderServiceImpl implements StringBuilderService {

    @Override
    public String buildInitials(EmployeeDto employee) {
        return String.join(". ", String.join(".", String.valueOf(employee.getName().charAt(0))
                                        , String.valueOf(employee.getPatronymic().charAt(0))).toUpperCase()
                                        , employee.getSurname());
    }

    @Override
    public String buildBuilding(BuildingDto building) {
        String workPlace = building.getBuildingType();
        if (building.getLogin() != null) {
            workPlace = String.join(" ", workPlace, "«", building.getLogin(), "»");
        }
        return String.join(", ", workPlace, buildAddress(building.getAddress()));
    }

    private String buildAddress(AddressDto address) {
        String string = String.join(", ", address.getCity()
                , String.join(" ", address.getStreet()
                        , "д.", String.valueOf(address.getHouseNumber())));
        if (address.getBuildingNumber() != null) {
            string = String.join(", ", string, String.join(""
                    , "корп.", String.valueOf(address.getBuildingNumber())));
        }
        if (address.getLetter() != null) {
            string = String.join(", ", string, String.join("", "лит.", address.getLetter()));
        }
        if (address.getIndex() != null) {
            return String.join(", ", String.valueOf(address.getIndex()), string);
        } else {
            return string;
        }
    }
}
