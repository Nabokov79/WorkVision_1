package ru.nabokovsg.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.nabokovsg.company.model.Organization;

import java.util.Set;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Organization findByFullName(String fullName);

    @Query("select o.id, o.fullName, o.shortName from Organization o")
    Set<Organization> findAllOrganization();
}