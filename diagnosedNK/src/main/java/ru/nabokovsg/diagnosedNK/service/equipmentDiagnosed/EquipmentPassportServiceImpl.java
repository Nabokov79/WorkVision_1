package ru.nabokovsg.diagnosedNK.service.equipmentDiagnosed;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.passport.EquipmentPassportDto;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.passport.ResponseEquipmentPassportDto;
import ru.nabokovsg.diagnosedNK.exceptions.NotFoundException;
import ru.nabokovsg.diagnosedNK.mapper.equipmentDiagnosed.EquipmentPassportMapper;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.EquipmentPassport;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.QEquipmentDiagnosed;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.QEquipmentPassport;
import ru.nabokovsg.diagnosedNK.repository.equipmentDiagnosed.EquipmentPassportRepository;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EquipmentPassportServiceImpl implements EquipmentPassportService {

    private final EquipmentPassportRepository repository;
    private final EquipmentPassportMapper mapper;
    private final EquipmentDiagnosedService equipmentService;
    private final EntityManager em;

    @Override
    public ResponseEquipmentPassportDto save(EquipmentPassportDto passportDto) {
        return mapper.mapToResponseEquipmentPassportDto(
                Objects.requireNonNullElseGet(
                        getByHeaderAndEquipmentId(passportDto.getEquipmentId(), passportDto.getHeader())
                        , () -> repository.save(mapper.mapToEquipmentPassport(passportDto
                                , equipmentService.getById(passportDto.getEquipmentId()))))
        );
    }

    @Override
    public ResponseEquipmentPassportDto update(EquipmentPassportDto passportDto) {
        if (repository.existsById(passportDto.getId())) {
            return mapper.mapToResponseEquipmentPassportDto(repository.save(mapper.mapToEquipmentPassport(passportDto
                    , equipmentService.getById(passportDto.getEquipmentId()))));
        }
        throw new NotFoundException(
                String.format("Equipment passport with id=%s not found for update", passportDto.getId())
        );
    }

    @Override
    public List<ResponseEquipmentPassportDto> getAll(Long id) {
        Set<EquipmentPassport> passports = repository.findAllByEquipmentDiagnosedId(id);
        if (passports.isEmpty()) {
            throw new NotFoundException(String.format("Equipment passport with equipmentId=%s not found", id));
        }
        return passports.stream()
                        .map(mapper::mapToResponseEquipmentPassportDto)
                        .toList();
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("Equipment Passport with id=%s not found for delete", id));
    }

    private EquipmentPassport getByHeaderAndEquipmentId(Long equipmentId, String header) {
        QEquipmentPassport passport = QEquipmentPassport.equipmentPassport;
        QEquipmentDiagnosed equipment = QEquipmentDiagnosed.equipmentDiagnosed;
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(equipment.id.eq(equipmentId));
        booleanBuilder.and(passport.header.eq(header));
        return new JPAQueryFactory(em).from(passport)
                .select(passport)
                .where(booleanBuilder)
                .fetchOne();
    }
}