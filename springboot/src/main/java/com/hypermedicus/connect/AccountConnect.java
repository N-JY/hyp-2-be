package com.hypermedicus.connect;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hypermedicus.payload.response.AccountResponse;
import com.hypermedicus.rds.entity.AccountClassificationEntity;
import com.hypermedicus.rds.entity.AccountEntity;
import com.hypermedicus.rds.repository.AccountClassificationEntityRepository;
import com.hypermedicus.rds.repository.AccountEntityRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AccountConnect {
    private final AccountEntityRepository accountEntityRepository;
    private final AccountClassificationEntityRepository accountClassificationEntityRepository;
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
    public void signUpAccount(AccountEntity accountEntity, AccountClassificationEntity accountClassificationEntity) {
        accountEntityRepository.save(accountEntity);
        accountClassificationEntityRepository.save(accountClassificationEntity);
    }

    @Transactional(readOnly = true)
    public AccountResponse getAccount(UUID uuid) {
        AccountEntity accountEntity = accountEntityRepository.findByUuid(uuid)
        .orElseThrow(() -> new NoSuchElementException("AccountEntity not found with UUID: " + uuid));
        
        AccountClassificationEntity accountClassificationEntity = accountClassificationEntityRepository.findByUuid(uuid)
        .orElseThrow(() -> new NoSuchElementException("accountClassificationEntity not found with UUID: " + uuid));       
        
        return AccountResponse.toResponse(accountEntity, accountClassificationEntity);
    }
}
