package az.edu.financialtransactionmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "interest_logs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InterestLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(nullable = false)
    private Double interestAmount;

    @Column(nullable = false)
    private LocalDateTime date;
}