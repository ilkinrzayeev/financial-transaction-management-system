package az.edu.financialtransactionmanagementsystem.service;

import az.edu.financialtransactionmanagementsystem.dto.AccountRequestDto;
import az.edu.financialtransactionmanagementsystem.dto.AccountResponseDto;

import java.util.List;

public interface AccountService {
    AccountResponseDto createAccount(AccountRequestDto request);

    List<AccountResponseDto> getAccountsByCustomerId(Long customerId);

    AccountResponseDto getAccount(Long accountId);
}