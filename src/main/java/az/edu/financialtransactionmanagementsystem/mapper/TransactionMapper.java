package az.edu.financialtransactionmanagementsystem.mapper;

import az.edu.financialtransactionmanagementsystem.dto.TransferResponseDto;
import az.edu.financialtransactionmanagementsystem.entity.Transaction;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransferResponseDto toResponseDto(Transaction entity);
}