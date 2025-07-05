package az.edu.financialtransactionmanagementsystem.repository;

import az.edu.financialtransactionmanagementsystem.entity.InterestLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestLogRepository extends JpaRepository<InterestLog, Long> {
    // Əlavə filtr və ya axtarış metodları lazım olsa, burada əlavə edə bilərsən
}