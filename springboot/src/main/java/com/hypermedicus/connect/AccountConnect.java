package com.hypermedicus.connect;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hypermedicus.payload.response.AccountResponse;
import com.hypermedicus.rds.entity.AccountInformationEntity;
import com.hypermedicus.rds.entity.AccountEntity;
import com.hypermedicus.rds.repository.AccountInformationEntityRepository;
import com.hypermedicus.rds.repository.AccountEntityRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AccountConnect {
    private final AccountEntityRepository accountEntityRepository;
    private final AccountInformationEntityRepository accountInformationEntityRepository;

    public void signUpAccount(AccountEntity accountEntity, AccountInformationEntity accountInformationEntity) {
        accountEntityRepository.save(accountEntity);
        accountInformationEntityRepository.save(accountInformationEntity);
    }

    @Transactional(readOnly = true)
    public AccountResponse getAccount(UUID uuid) {
        AccountEntity accountEntity = accountEntityRepository.findByUuid(uuid)
        .orElseThrow(() -> new NoSuchElementException("AccountEntity not found with UUID: " + uuid));
        
        AccountInformationEntity accountInformationEntity = accountInformationEntityRepository.findByUuid(uuid)
        .orElseThrow(() -> new NoSuchElementException("accountInformationEntity not found with UUID: " + uuid));       
        
        return AccountResponse.toResponse(accountEntity, accountInformationEntity);
    }
}
