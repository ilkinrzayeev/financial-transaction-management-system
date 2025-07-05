package az.edu.financialtransactionmanagementsystem.service;

import az.edu.financialtransactionmanagementsystem.dto.CustomerRequestDto;
import az.edu.financialtransactionmanagementsystem.dto.CustomerResponseDto;

public interface CustomerService {
    CustomerResponseDto createCustomer(CustomerRequestDto request);

    CustomerResponseDto updateCustomer(Long customerId, CustomerRequestDto request);

    CustomerResponseDto getCustomer(Long customerId);
}