package az.edu.financialtransactionmanagementsystem.controller;

import az.edu.financialtransactionmanagementsystem.dto.AccountRequestDto;
import az.edu.financialtransactionmanagementsystem.dto.AccountResponseDto;
import az.edu.financialtransactionmanagementsystem.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponseDto> createAccount(@Valid @RequestBody AccountRequestDto request) {
        AccountResponseDto response = accountService.createAccount(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<AccountResponseDto>> getAccountsByCustomerId(@PathVariable Long customerId) {
        List<AccountResponseDto> response = accountService.getAccountsByCustomerId(customerId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponseDto> getAccount(@PathVariable Long accountId) {
        AccountResponseDto response = accountService.getAccount(accountId);
        return ResponseEntity.ok(response);
    }
}