package com.hypermedicus.mapper;

import com.hypermedicus.model.AccountDTO;
import com.hypermedicus.rds.entity.AccountEntity;
import com.hypermedicus.rds.entity.AccountClassificationEntity;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mapping(target = "uuid", expression = "java(uuid)")
    AccountEntity toAccountEntity(AccountDTO dto, UUID uuid);

    @Mapping(target = "uuid", expression = "java(uuid)")
    AccountClassificationEntity toAccountClassificationEntity(AccountDTO dto, UUID uuid);
}
