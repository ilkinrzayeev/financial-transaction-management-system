package az.edu.financialtransactionmanagementsystem.service;

import az.edu.financialtransactionmanagementsystem.dto.TransferRequestDto;
import az.edu.financialtransactionmanagementsystem.dto.TransferResponseDto;

public interface TransferService {
    TransferResponseDto transfer(TransferRequestDto request);
}