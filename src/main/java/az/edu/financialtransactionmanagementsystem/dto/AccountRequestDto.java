package az.edu.financialtransactionmanagementsystem.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccountRequestDto {
    @NotNull(message = "Customer ID is required")
    private Long customerId;

    @NotNull(message = "Initial balance is required")
    @Min(value = 0, message = "Initial balance must be zero or positive")
    private Double initialBalance;
}