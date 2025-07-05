package az.edu.financialtransactionmanagementsystem.service.impl;

import az.edu.financialtransactionmanagementsystem.dto.CustomerRequestDto;
import az.edu.financialtransactionmanagementsystem.dto.CustomerResponseDto;
import az.edu.financialtransactionmanagementsystem.entity.Customer;
import az.edu.financialtransactionmanagementsystem.exception.CustomException;
import az.edu.financialtransactionmanagementsystem.exception.ResourceNotFoundException;
import az.edu.financialtransactionmanagementsystem.mapper.CustomerMapper;
import az.edu.financialtransactionmanagementsystem.repository.CustomerRepository;
import az.edu.financialtransactionmanagementsystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    @Transactional
    public CustomerResponseDto createCustomer(CustomerRequestDto request) {
        if (customerRepository.existsByEmail(request.getEmail())) {
            throw new CustomException("Email already exists");
        }
        Customer customer = customerMapper.toEntity(request);
        Customer saved = customerRepository.save(customer);
        return CustomerResponseDto.builder()
                .customerId(saved.getCustomerId())
                .firstName(saved.getFirstName())
                .lastName(saved.getLastName())
                .email(saved.getEmail())
                .message("Customer created successfully")
                .build();
    }

    @Override
    @Transactional
    public CustomerResponseDto updateCustomer(Long customerId, CustomerRequestDto request) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        Customer updated = customerRepository.save(customer);
        return CustomerResponseDto.builder()
                .customerId(updated.getCustomerId())
                .firstName(updated.getFirstName())
                .lastName(updated.getLastName())
                .email(updated.getEmail())
                .message("Customer updated successfully")
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerResponseDto getCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        return customerMapper.toResponseDto(customer);
    }
}