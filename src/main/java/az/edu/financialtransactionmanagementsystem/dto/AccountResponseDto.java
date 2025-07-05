package az.edu.financialtransactionmanagementsystem.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountResponseDto {
    private Long accountId;
    private Long customerId;
    private Double balance;
    private String message;
}