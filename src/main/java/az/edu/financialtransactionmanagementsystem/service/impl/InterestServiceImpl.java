package az.edu.financialtransactionmanagementsystem.service.impl;

import az.edu.financialtransactionmanagementsystem.entity.Account;
import az.edu.financialtransactionmanagementsystem.entity.InterestLog;
import az.edu.financialtransactionmanagementsystem.repository.AccountRepository;
import az.edu.financialtransactionmanagementsystem.repository.InterestLogRepository;
import az.edu.financialtransactionmanagementsystem.service.InterestService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InterestServiceImpl implements InterestService {

    private final AccountRepository accountRepository;
    private final InterestLogRepository interestLogRepository;
    private static final Logger logger = LoggerFactory.getLogger(InterestServiceImpl.class);

    private static final double DAILY_INTEREST_RATE = 0.0005;

    @Override
    @Transactional
    @Scheduled(cron = "0 0 0 * * ?") // Hər gün gecə 00:00-da
    public void calculateAndApplyDailyInterest() {
        List<Account> accounts = accountRepository.findAll();
        for (Account account : accounts) {
            double interest = account.getBalance() * DAILY_INTEREST_RATE;
            if (interest > 0) {
                account.setBalance(account.getBalance() + interest);
                accountRepository.save(account);

                InterestLog log = InterestLog.builder()
                        .account(account)
                        .interestAmount(interest)
                        .date(LocalDateTime.now())
                        .build();
                interestLogRepository.save(log);

                logger.info("Interest applied to account {}: {}", account.getAccountId(), interest);
            }
        }
    }
}