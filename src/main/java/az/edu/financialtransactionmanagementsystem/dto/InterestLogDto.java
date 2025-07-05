package az.edu.financialtransactionmanagementsystem.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class InterestLogDto {
    private Long logId;
    private Long accountId;
    private Double interestAmount;
    private LocalDateTime date;
}