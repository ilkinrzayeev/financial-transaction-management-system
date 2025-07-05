package az.edu.financialtransactionmanagementsystem.service.impl;

import az.edu.financialtransactionmanagementsystem.dto.TransferRequestDto;
import az.edu.financialtransactionmanagementsystem.dto.TransferResponseDto;
import az.edu.financialtransactionmanagementsystem.entity.Account;
import az.edu.financialtransactionmanagementsystem.entity.Transaction;
import az.edu.financialtransactionmanagementsystem.exception.InsufficientBalanceException;
import az.edu.financialtransactionmanagementsystem.exception.ResourceNotFoundException;
import az.edu.financialtransactionmanagementsystem.mapper.TransactionMapper;
import az.edu.financialtransactionmanagementsystem.repository.AccountRepository;
import az.edu.financialtransactionmanagementsystem.repository.TransactionRepository;
import az.edu.financialtransactionmanagementsystem.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private static final Logger logger = LoggerFactory.getLogger(TransferServiceImpl.class);

    @Override
    @Transactional
    public TransferResponseDto transfer(TransferRequestDto request) {
        if (request.getFromAccountId().equals(request.getToAccountId())) {
            throw new IllegalArgumentException("Source and destination accounts must be different");
        }

        Account fromAccount = accountRepository.findById(request.getFromAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Source account not found"));
        Account toAccount = accountRepository.findById(request.getToAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Destination account not found"));

        if (fromAccount.getBalance() < request.getAmount()) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        fromAccount.setBalance(fromAccount.getBalance() - request.getAmount());
        toAccount.setBalance(toAccount.getBalance() + request.getAmount());

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        Transaction transaction = Transaction.builder()
                .fromAccount(fromAccount)
                .toAccount(toAccount)
                .amount(request.getAmount())
                .timestamp(LocalDateTime.now())
                .build();

        Transaction savedTransaction = transactionRepository.save(transaction);

        logger.info("Transfer successful: {} -> {} | Amount: {}", fromAccount.getAccountId(), toAccount.getAccountId(), request.getAmount());

        return TransferResponseDto.builder()
                .transactionId(savedTransaction.getTransactionId())
                .message("Transfer successful")
                .build();
    }
}