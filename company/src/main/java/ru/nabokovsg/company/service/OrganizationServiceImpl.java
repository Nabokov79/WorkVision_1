package ru.nabokovsg.company.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.company.dto.organization.OrganizationDto;
import ru.nabokovsg.company.dto.organization.ResponseOrganizationDto;
import ru.nabokovsg.company.dto.organization.ShortResponseOrganizationDto;
import ru.nabokovsg.company.exceptions.NotFoundException;
import ru.nabokovsg.company.mapper.OrganizationMapper;
import ru.nabokovsg.company.model.Organization;
import ru.nabokovsg.company.model.enums.DivisionType;
import ru.nabokovsg.company.repository.OrganizationRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository repository;
    private final OrganizationMapper mapper;
    private final AddressService addressService;

    @Override
    public ShortResponseOrganizationDto save(OrganizationDto organizationDto) {
        return mapper.mapToShortOrganizationDto(
                Objects.requireNonNullElseGet(repository.findByFullName(organizationDto.getFullName())
                        , () -> repository.save(mapper.mapToOrganization(organizationDto
                                                   , addressService.get(organizationDto.getAddressId())
                                                   , DivisionType.ORGANIZATION)))
        );
    }

    @Override
    public ShortResponseOrganizationDto update(OrganizationDto organizationDto) {
        if (repository.existsById(organizationDto.getId())) {
            return mapper.mapToShortOrganizationDto(
                    repository.save(
                            mapper.mapToOrganization(organizationDto
                                                   , addressService.get(organizationDto.getAddressId())
                                                   , DivisionType.ORGANIZATION))
            );
        }
        throw new NotFoundException(
                String.format("Organization with name=%s not found for update.", organizationDto.getFullName()));
    }

    @Override
    public ResponseOrganizationDto get(Long id) {
        return mapper.mapToOrganizationDto(getById(id));
    }

    @Override
    public List<ShortResponseOrganizationDto> getAll() {
        return repository.findAll().stream()
                                   .map(mapper::mapToShortOrganizationDto)
                                   .toList();
    }


    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
       throw new NotFoundException(String.format("Organization with id=%s not found for delete.", id));
    }

    @Override
    public Organization getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(
                                                    String.format("Organization with id=%s not found for license",id)));
    }
}