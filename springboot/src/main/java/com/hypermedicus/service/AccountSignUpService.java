package com.hypermedicus.service;

import com.hypermedicus.mapper.AccountSignUpMapper;
import com.hypermedicus.model.AccountSignUpDTO;
import com.hypermedicus.rds.entity.AccountEntity;
import com.hypermedicus.rds.entity.AccountClassificationEntity;
import com.hypermedicus.rds.repository.AccountClassificationRepository;
import com.hypermedicus.rds.repository.AccountEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AccountSignUpService {

    private final AccountSignUpMapper mapper;
    private final AccountEntityRepository accountEntityRepository;
    private final AccountClassificationRepository accountClassificationRepository;

    public AccountSignUpService(AccountSignUpMapper mapper, AccountEntityRepository accountEntityRepository, AccountClassificationRepository accountClassificationRepository) {
        this.mapper = mapper;
        this.accountEntityRepository = accountEntityRepository;
        this.accountClassificationRepository = accountClassificationRepository;
    }

    @Transactional
    public void signUpAccount(AccountSignUpDTO dto) {
        UUID uuid = UUID.randomUUID();
        dto.setUuid(uuid);
        
        AccountEntity accountEntity = mapper.toAccountEntity(dto, uuid);
        AccountClassificationEntity accountClassificationEntity = mapper.toAccountClassificationEntity(dto, uuid);

        accountEntityRepository.save(accountEntity);
        accountClassificationRepository.save(accountClassificationEntity);
    }
}
