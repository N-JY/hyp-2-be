package com.hypermedicus.service;

import com.hypermedicus.common.utils.JWTUtil;
import com.hypermedicus.connect.AccountConnect;
import com.hypermedicus.mapper.AccountMapper;
import com.hypermedicus.model.AccountDTO;
import com.hypermedicus.payload.response.AccountResponse;
import com.hypermedicus.rds.entity.AccountEntity;
import com.hypermedicus.rds.entity.AccountInformationEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AccountService {

    private final AccountMapper mapper;
    private final AccountConnect accountConnect;

    public AccountService(AccountMapper mapper
    , AccountConnect accountConnect) {
        this.mapper = mapper;
        this.accountConnect = accountConnect;
    }

    @Transactional
    public AccountResponse signUpAccount(AccountDTO dto) {
        UUID uuid = UUID.randomUUID();
        dto.setUuid(uuid);

        AccountEntity accountEntity = mapper.toAccountEntity(dto, uuid);
        AccountInformationEntity accountInformationEntity = mapper.toAccountInformationEntity(dto, uuid);

        accountConnect.signUpAccount(accountEntity, accountInformationEntity); 

        AccountResponse accountResponse = accountConnect.getAccount(uuid);
        
        String accessToken = JWTUtil.generateToken(uuid, 10);
        String refreshToken = JWTUtil.generateToken(uuid, 60*24);

        accountResponse.setAccessToken(accessToken);
        accountResponse.setRefreshToken(refreshToken);
        
        return accountResponse;
    }
}
