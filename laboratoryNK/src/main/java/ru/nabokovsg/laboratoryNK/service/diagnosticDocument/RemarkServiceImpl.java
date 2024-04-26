package ru.nabokovsg.laboratoryNK.service.diagnosticDocument;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.laboratoryNK.dto.remark.RemarkDto;
import ru.nabokovsg.laboratoryNK.dto.remark.ResponseRemarkDto;
import ru.nabokovsg.laboratoryNK.exceptions.BadRequestException;
import ru.nabokovsg.laboratoryNK.exceptions.NotFoundException;
import ru.nabokovsg.laboratoryNK.mapper.diagnosticDocument.RemarkMapper;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocument.DiagnosticDocument;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocument.QRemark;
import ru.nabokovsg.laboratoryNK.model.diagnosticDocument.Remark;
import ru.nabokovsg.laboratoryNK.model.laboratoryEmployee.LaboratoryEmployee;
import ru.nabokovsg.laboratoryNK.repository.diagnosticDocument.RemarkRepository;
import ru.nabokovsg.laboratoryNK.service.laboratoryEmployee.LaboratoryEmployeeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RemarkServiceImpl implements RemarkService {

    private final RemarkRepository repository;
    private final RemarkMapper mapper;
    private final LaboratoryEmployeeService employeeService;
    private final DiagnosticDocumentService documentService;
    private final EntityManager em;

    @Override
    public ResponseRemarkDto save(RemarkDto remarkDto) {
        Remark remark = repository.findByDocumentIdAndRemark(remarkDto.getDocumentId(), remarkDto.getRemark());
        if (remark == null) {
            remark = repository.save(mapper.mapToRemark(remarkDto
                            , employeeService.getById(remarkDto.getEmployeeId())
                            , documentService.getById(remarkDto.getDocumentId())));
            return mapper.mapToRemarkDto(remark);
        }
       throw new BadRequestException(String.format("Remark was found: %s", remark.getRemark()));
    }

    @Override
    public ResponseRemarkDto update(RemarkDto remarkDto) {
        Remark remark = getById(remarkDto.getId());
        remark = repository.save(mapper.mapToRemark(remarkDto
                               , employeeService.getById(remarkDto.getEmployeeId())
                               , remark.getDocument()));
        return mapper.mapToRemarkDto(remark);
    }

    @Override
    public List<ResponseRemarkDto> getAll(Long id, Boolean inspector) {
//        if (inspector) {
//            return repository.findAllByInspectorIdOrderByIdDesc(id)
//                             .stream()
//                             .map(mapper::mapToFullRemarkDto)
//                             .toList();
//        } else {
//            QRemark remark = QRemark.remark1;
//            return new JPAQueryFactory(em).from(remark)
//                                          .select(remark)
//                                          .where(QSubscriber.subscriber.id.eq(id))
//                                          .orderBy(remark.id.desc())
//                                          .fetch()
//                                          .stream()
//                                          .map(mapper::mapToFullRemarkDto)
//                                          .toList();
//        }
        return null;
    }

    private Remark getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Remark with id=%s not found", id)));
    }

   private void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("Remark with id=%s not found for delete", id));
    }
}