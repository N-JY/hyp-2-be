package com.hypermedicus.mapper;

import com.hypermedicus.model.AccountDTO;
import com.hypermedicus.rds.entity.AccountEntity;
import com.hypermedicus.rds.entity.AccountInformationEntity;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mapping(target = "uuid", expression = "java(uuid)")
    AccountEntity toAccountEntity(AccountDTO dto, UUID uuid);

    @Mapping(target = "uuid", expression = "java(uuid)")
    AccountInformationEntity toAccountInformationEntity(AccountDTO dto, UUID uuid);
}
