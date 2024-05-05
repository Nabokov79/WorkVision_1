package ru.nabokovsg.diagnosedNK.service.equipmentDiagnosed;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.passport.EquipmentPassportDto;
import ru.nabokovsg.diagnosedNK.dto.equipmentDiagnosed.passport.ResponseEquipmentPassportDto;
import ru.nabokovsg.diagnosedNK.exceptions.NotFoundException;
import ru.nabokovsg.diagnosedNK.mapper.equipmentDiagnosed.EquipmentPassportMapper;
import ru.nabokovsg.diagnosedNK.model.equipmentDiagnosed.EquipmentPassport;
import ru.nabokovsg.diagnosedNK.repository.equipmentDiagnosed.EquipmentPassportRepository;

@Service
@RequiredArgsConstructor
public class EquipmentPassportServiceImpl implements EquipmentPassportService {

    private final EquipmentPassportRepository repository;
    private final EquipmentPassportMapper mapper;
    private final EquipmentDiagnosedService equipmentService;

    @Override
    public ResponseEquipmentPassportDto save(EquipmentPassportDto passportDto) {
        EquipmentPassport passport = repository.findByHeaderAndEquipmentId(passportDto.getHeader()
                                                                         , passportDto.getEquipmentId());
        if (passport == null)  {
            passport = repository.save(mapper.mapToEquipmentPassport(passportDto
                                                , equipmentService.getById(passportDto.getEquipmentId())));
        }
        return mapper.mapToFullEquipmentPassportDto(passport);
    }

    @Override
    public ResponseEquipmentPassportDto update(EquipmentPassportDto passportDto) {
        if (repository.existsById(passportDto.getId())) {
            return mapper.mapToFullEquipmentPassportDto(repository.save(mapper.mapToEquipmentPassport(passportDto
                    , equipmentService.getById(passportDto.getEquipmentId()))));
        }
        throw new NotFoundException(
                String.format("Equipment Passport with id=%s not found for update", passportDto.getId())
        );
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("Equipment Passport with id=%s not found for delete", id));
    }
}