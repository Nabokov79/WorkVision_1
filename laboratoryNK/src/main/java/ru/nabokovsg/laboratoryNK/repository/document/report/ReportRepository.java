package ru.nabokovsg.laboratoryNK.repository.document.report;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.laboratoryNK.model.document.report.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
}