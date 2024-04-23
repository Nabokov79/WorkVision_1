package ru.nabokovsg.company.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.company.dto.building.BuildingDto;
import ru.nabokovsg.company.dto.building.ResponseBuildingDto;
import ru.nabokovsg.company.dto.building.ShortResponseBuildingDto;
import ru.nabokovsg.company.exceptions.BadRequestException;
import ru.nabokovsg.company.exceptions.NotFoundException;
import ru.nabokovsg.company.mapper.BuildingMapper;
import ru.nabokovsg.company.model.Building;
import ru.nabokovsg.company.model.QBuilding;
import ru.nabokovsg.company.model.enums.BuildingType;
import ru.nabokovsg.company.repository.BuildingRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository repository;
    private final BuildingMapper mapper;
    private final ExploitationRegionService regionService;
    private final AddressService addressService;
    private final EntityManager entityManager;
    private final static String BOILER_ROOM = "котельная";
    private final static String CHP = "ЦТП";
    private final static String IHP = "ИТП";

    @Override
    public ShortResponseBuildingDto save(BuildingDto buildingDto) {
        return mapper.mapToShortBuildingDto(
                Objects.requireNonNullElseGet(getDuplicateByPredicate(buildingDto)
                        , () -> repository.save(
                                mapper.mapToBuilding(buildingDto
                                                   , getConstant(buildingDto.getBuildingType())
                                                   , addressService.get(buildingDto.getAddressId())
                                                   , regionService.getById(buildingDto.getExploitationRegionId())))));
    }

    @Override
    public ShortResponseBuildingDto update(BuildingDto buildingDto) {
        if (repository.existsById(buildingDto.getId())) {
            return mapper.mapToShortBuildingDto(
                    repository.save(mapper.mapToBuilding(buildingDto
                                                       , getConstant(buildingDto.getBuildingType())
                                                       , addressService.get(buildingDto.getAddressId())
                                                       , regionService.getById(buildingDto.getExploitationRegionId())))
            );
        }
        throw new NotFoundException(String.format("Building with id=%s not found for update.", buildingDto.getId()));
    }

    @Override
    public ResponseBuildingDto get(Long id) {
        return mapper.mapToFullBuildingDto(getById(id));
    }

    @Override
    public Building getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Building with id=%s not found", id)));
    }

    @Override
    public List<ShortResponseBuildingDto> getAll(Long id) {
        return repository.findAllByExploitationRegionId(id)
                         .stream()
                         .map(mapper::mapToShortBuildingDto)
                         .toList();
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("Building with id=%s not found for delete.", id));
    }

    private Building getDuplicateByPredicate(BuildingDto buildingDto) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(QBuilding.building.exploitationRegion.id.eq(buildingDto.getExploitationRegionId()));
        booleanBuilder.and(QBuilding.building.address.id.eq(buildingDto.getAddressId()));
        booleanBuilder.and(QBuilding.building.buildingType.eq(buildingDto.getBuildingType()));
        if (buildingDto.getLogin() != null) {
            booleanBuilder.and(QBuilding.building.login.eq(buildingDto.getLogin()));
        }
        QBuilding building = QBuilding.building;
        return new JPAQueryFactory(entityManager).from(building)
                .select(building)
                .where(booleanBuilder)
                .fetchOne();
    }

    private String getConstant(String buildingType) {
        switch (convertToBuildingType(buildingType)) {
            case BOILER_ROOM -> {
                return BOILER_ROOM;
            }
            case CHP -> {
                return CHP;
            }
            case IHP -> {
                return IHP;
            }
            default -> throw new BadRequestException(
                    String.format("Unknown building type=%s", buildingType));
        }
    }

    private BuildingType convertToBuildingType(String buildingType) {
        return BuildingType.from(buildingType)
                .orElseThrow(
                       () -> new BadRequestException(String.format("Unknown data format buildingType=%s", buildingType))
                );
    }
}