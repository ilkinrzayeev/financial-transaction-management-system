package az.edu.financialtransactionmanagementsystem.controller;

import az.edu.financialtransactionmanagementsystem.dto.InterestLogDto;
import az.edu.financialtransactionmanagementsystem.service.InterestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/interest")
@RequiredArgsConstructor
public class InterestController {

    private final InterestService interestService;

    @PostMapping("/calculate")
    public ResponseEntity<String> calculateInterest() {
        interestService.calculateAndApplyDailyInterest();
        return ResponseEntity.ok("Daily interest calculated and applied to all accounts.");
    }

    @GetMapping("/logs")
    public ResponseEntity<List<InterestLogDto>> getAllInterestLogs() {
        List<InterestLogDto> logs = interestService.getAllInterestLogs();
        return ResponseEntity.ok(logs);
    }
}