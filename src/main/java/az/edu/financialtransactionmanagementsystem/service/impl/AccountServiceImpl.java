package az.edu.financialtransactionmanagementsystem.service.impl;

import az.edu.financialtransactionmanagementsystem.dto.AccountRequestDto;
import az.edu.financialtransactionmanagementsystem.dto.AccountResponseDto;
import az.edu.financialtransactionmanagementsystem.entity.Account;
import az.edu.financialtransactionmanagementsystem.entity.Customer;
import az.edu.financialtransactionmanagementsystem.exception.ResourceNotFoundException;
import az.edu.financialtransactionmanagementsystem.mapper.AccountMapper;
import az.edu.financialtransactionmanagementsystem.repository.AccountRepository;
import az.edu.financialtransactionmanagementsystem.repository.CustomerRepository;
import az.edu.financialtransactionmanagementsystem.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final AccountMapper accountMapper;

    @Override
    @Transactional
    public AccountResponseDto createAccount(AccountRequestDto request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        Account account = accountMapper.toEntity(request, customer);
        Account saved = accountRepository.save(account);
        return AccountResponseDto.builder()
                .accountId(saved.getAccountId())
                .customerId(saved.getCustomer().getCustomerId())
                .balance(saved.getBalance())
                .message("Account created successfully")
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountResponseDto> getAccountsByCustomerId(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        return accountRepository.findByCustomer(customer)
                .stream()
                .map(accountMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public AccountResponseDto getAccount(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        return accountMapper.toResponseDto(account);
    }
}