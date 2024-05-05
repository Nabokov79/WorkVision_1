package ru.nabokovsg.diagnosedNK.mapper.norms;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.diagnosedNK.dto.norms.defects.DefectDto;
import ru.nabokovsg.diagnosedNK.dto.norms.defects.ResponseDefectDto;
import ru.nabokovsg.diagnosedNK.dto.norms.defects.ResponseShortDefectDto;
import ru.nabokovsg.diagnosedNK.model.norms.ActionsOnParameter;
import ru.nabokovsg.diagnosedNK.model.norms.Defect;

@Mapper(componentModel = "spring")
public interface DefectMapper {

    @Mapping(source = "defectDto.id", target = "id")
    @Mapping(source = "defectDto.defectName", target = "defectName")
    @Mapping(source = "actionsOnParameter", target = "actionsOnParameter")
    @Mapping(source = "defectDto.notMeetRequirements", target = "notMeetRequirements")
    Defect mapToDefect(DefectDto defectDto
                     , ActionsOnParameter actionsOnParameter);

    ResponseDefectDto mapToResponseDefectDto(Defect defect);

    ResponseShortDefectDto mapToResponseShortDefectDto(Defect defect);
}