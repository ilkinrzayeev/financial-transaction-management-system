package az.edu.financialtransactionmanagementsystem.mapper;

import az.edu.financialtransactionmanagementsystem.dto.InterestLogDto;
import az.edu.financialtransactionmanagementsystem.entity.InterestLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InterestLogMapper {
    @Mapping(target = "accountId", source = "account.accountId")
    InterestLogDto toDto(InterestLog entity);
}