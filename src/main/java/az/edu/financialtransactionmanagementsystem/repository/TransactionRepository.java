package az.edu.financialtransactionmanagementsystem.repository;

import az.edu.financialtransactionmanagementsystem.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}