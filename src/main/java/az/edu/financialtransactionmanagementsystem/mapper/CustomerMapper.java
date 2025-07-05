package az.edu.financialtransactionmanagementsystem.mapper;

import az.edu.financialtransactionmanagementsystem.dto.CustomerRequestDto;
import az.edu.financialtransactionmanagementsystem.dto.CustomerResponseDto;
import az.edu.financialtransactionmanagementsystem.entity.Customer;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toEntity(CustomerRequestDto dto);

    CustomerResponseDto toResponseDto(Customer entity);
}