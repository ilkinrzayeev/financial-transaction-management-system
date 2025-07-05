package az.edu.financialtransactionmanagementsystem.controller;

import az.edu.financialtransactionmanagementsystem.dto.TransferRequestDto;
import az.edu.financialtransactionmanagementsystem.dto.TransferResponseDto;
import az.edu.financialtransactionmanagementsystem.service.TransferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @PostMapping
    public ResponseEntity<TransferResponseDto> transfer(@Valid @RequestBody TransferRequestDto request) {
        TransferResponseDto response = transferService.transfer(request);
        return ResponseEntity.ok(response);
    }
}