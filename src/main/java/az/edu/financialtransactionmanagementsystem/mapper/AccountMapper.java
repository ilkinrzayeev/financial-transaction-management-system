package az.edu.financialtransactionmanagementsystem.mapper;

import az.edu.financialtransactionmanagementsystem.dto.AccountRequestDto;
import az.edu.financialtransactionmanagementsystem.dto.AccountResponseDto;
import az.edu.financialtransactionmanagementsystem.entity.Account;
import az.edu.financialtransactionmanagementsystem.entity.Customer;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mapping(target = "accountId", ignore = true)
    @Mapping(target = "customer", source = "customer")
    @Mapping(target = "balance", source = "initialBalance")
    Account toEntity(AccountRequestDto dto, Customer customer);

    @Mapping(target = "customerId", source = "customer.customerId")
    AccountResponseDto toResponseDto(Account entity);
}