package az.edu.financialtransactionmanagementsystem.repository;

import az.edu.financialtransactionmanagementsystem.entity.Account;
import az.edu.financialtransactionmanagementsystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByCustomer(Customer customer);
    List<Account> findByCustomerCustomerId(Long customerId);
}