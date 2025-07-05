package az.edu.financialtransactionmanagementsystem.controller;

import az.edu.financialtransactionmanagementsystem.dto.CustomerRequestDto;
import az.edu.financialtransactionmanagementsystem.dto.CustomerResponseDto;
import az.edu.financialtransactionmanagementsystem.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDto> createCustomer(@Valid @RequestBody CustomerRequestDto request) {
        CustomerResponseDto response = customerService.createCustomer(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> updateCustomer(
            @PathVariable Long id,
            @Valid @RequestBody CustomerRequestDto request) {
        CustomerResponseDto response = customerService.updateCustomer(id, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomer(@PathVariable Long id) {
        CustomerResponseDto response = customerService.getCustomer(id);
        return ResponseEntity.ok(response);
    }
}