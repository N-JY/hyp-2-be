package com.hypermedicus.mapper;

import com.hypermedicus.model.AccountSignUpDTO;
import com.hypermedicus.rds.entity.AccountEntity;
import com.hypermedicus.rds.entity.AccountClassificationEntity;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AccountSignUpMapper {

    @Mapping(target = "uuid", expression = "java(uuid)")
    AccountEntity toAccountEntity(AccountSignUpDTO dto, UUID uuid);

    @Mapping(target = "uuid", expression = "java(uuid)")
    AccountClassificationEntity toAccountClassificationEntity(AccountSignUpDTO dto, UUID uuid);
}
