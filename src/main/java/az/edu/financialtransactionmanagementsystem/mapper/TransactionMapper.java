package az.edu.financialtransactionmanagementsystem.mapper;

import az.edu.financialtransactionmanagementsystem.dto.TransferResponseDto;
import az.edu.financialtransactionmanagementsystem.entity.Transaction;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    @Mapping(target = "message", ignore = true)
    @Mapping(target = "error", ignore = true)
    TransferResponseDto toResponseDto(Transaction entity);
}