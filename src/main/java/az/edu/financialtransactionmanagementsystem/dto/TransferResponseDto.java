package az.edu.financialtransactionmanagementsystem.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferResponseDto {
    private Long transactionId;
    private String message;
    private String error;
}