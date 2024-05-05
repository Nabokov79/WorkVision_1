package ru.nabokovsg.diagnosedNK.mapper.norms;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.diagnosedNK.dto.norms.elementRepair.ElementRepairDto;
import ru.nabokovsg.diagnosedNK.dto.norms.elementRepair.ResponseElementRepairDto;
import ru.nabokovsg.diagnosedNK.dto.norms.elementRepair.ResponseShortElementRepairDto;
import ru.nabokovsg.diagnosedNK.model.norms.ActionsOnParameter;
import ru.nabokovsg.diagnosedNK.model.norms.ElementRepair;

@Mapper(componentModel = "spring")
public interface ElementRepairMapper {

    @Mapping(source = "repairDto.id", target = "id")
    @Mapping(source = "repairDto.repairName", target = "repairName")
    @Mapping(source = "actionsOnParameter", target = "actionsOnParameter")
    ElementRepair mapToElementRepair(ElementRepairDto repairDto
                                   , ActionsOnParameter actionsOnParameter);

    ResponseElementRepairDto mapToResponseElementRepairDto(ElementRepair repair);

    ResponseShortElementRepairDto mapToResponseShortElementRepairDto(ElementRepair repair);
}