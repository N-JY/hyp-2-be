package com.hypermedicus.service;

import com.hypermedicus.connect.AccountConnect;
import com.hypermedicus.mapper.AccountMapper;
import com.hypermedicus.model.AccountDTO;
import com.hypermedicus.payload.response.AccountResponse;
import com.hypermedicus.rds.entity.AccountEntity;
import com.hypermedicus.rds.entity.AccountClassificationEntity;
import com.hypermedicus.rds.repository.AccountClassificationEntityRepository;
import com.hypermedicus.rds.repository.AccountEntityRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AccountService {

    private final AccountMapper mapper;
    private final AccountEntityRepository accountEntityRepository;
    private final AccountClassificationEntityRepository accountClassificationEntityRepository;
    private final AccountConnect accountConnect;

    public AccountService(AccountMapper mapper
    , AccountEntityRepository accountEntityRepository
    , AccountClassificationEntityRepository accountClassificationEntityRepository
    , AccountConnect accountConnect) {
        this.mapper = mapper;
        this.accountEntityRepository = accountEntityRepository;
        this.accountClassificationEntityRepository = accountClassificationEntityRepository;
        this.accountConnect = accountConnect;
    }

    @Transactional
    public AccountResponse signUpAccount(AccountDTO dto) {
        UUID uuid = UUID.randomUUID();
        dto.setUuid(uuid);

        AccountEntity accountEntity = mapper.toAccountEntity(dto, uuid);
        AccountClassificationEntity accountClassificationEntity = mapper.toAccountClassificationEntity(dto, uuid);

        accountConnect.signUpAccount(accountEntity, accountClassificationEntity); 

        accountEntityRepository.save(accountEntity);
        accountClassificationEntityRepository.save(accountClassificationEntity);

        AccountResponse accountResponse = accountConnect.getAccount(uuid);
        return accountResponse;
    }

    /*
    @Transactional(readOnly = true)
    public ApiResponse<AccountResponse> getAccount(UUID uuid) {
        AccountEntity accountEntity = accountEntityRepository.findByUuid(uuid)
        .orElseThrow(() -> new NoSuchElementException("AccountEntity not found with UUID: " + uuid));
        
        AccountClassificationEntity accountClassificationEntity = accountClassificationEntityRepository.findByUuid(uuid)
        .orElseThrow(() -> new NoSuchElementException("accountClassificationEntity not found with UUID: " + uuid));
        
        ApiResponse<AccountResponse> apiResponse = ApiResponse.ok(AccountResponse.toResponse(accountEntity, accountClassificationEntity));

        return apiResponse;
    }
     */
 
}
