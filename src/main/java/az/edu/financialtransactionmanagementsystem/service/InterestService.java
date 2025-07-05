package az.edu.financialtransactionmanagementsystem.service;

import az.edu.financialtransactionmanagementsystem.dto.InterestLogDto;

import java.util.List;

public interface InterestService {
    void calculateAndApplyDailyInterest();

    List<InterestLogDto> getAllInterestLogs();

}