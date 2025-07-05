package az.edu.financialtransactionmanagementsystem.repository;

import az.edu.financialtransactionmanagementsystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByEmail(String email);
}