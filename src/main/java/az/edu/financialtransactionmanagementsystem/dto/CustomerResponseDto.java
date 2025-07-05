package az.edu.financialtransactionmanagementsystem.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponseDto {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String message;
}