package ru.nabokovsg.measurementNK.mapper.norms;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nabokovsg.measurementNK.dto.norms.defects.DefectDto;
import ru.nabokovsg.measurementNK.dto.norms.defects.ResponseDefectDto;
import ru.nabokovsg.measurementNK.dto.norms.defects.ResponseShortDefectDto;
import ru.nabokovsg.measurementNK.model.norms.ActionsOnParameter;
import ru.nabokovsg.measurementNK.model.norms.Defect;

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