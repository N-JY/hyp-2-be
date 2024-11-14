package com.hypermedicus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hypermedicus.model.AccountDTO;
import com.hypermedicus.payload.response.AccountResponse;
import com.hypermedicus.payload.response.ApiResponse;
import com.hypermedicus.rds.entity.AccountClassificationEntity;
import com.hypermedicus.rds.entity.AccountEntity;
import com.hypermedicus.rds.repository.AccountClassificationEntityRepository;
import com.hypermedicus.rds.repository.AccountEntityRepository;
import com.hypermedicus.service.AccountService;

import lombok.extern.log4j.Log4j2;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
class Test_AccountService {

    @Autowired
    private AccountService accountService;

    private AccountDTO accountDTO;

    
    @Autowired
    private AccountEntityRepository accountEntityRepository;

    @Autowired
    private AccountClassificationEntityRepository accountClassificationEntityRepository;

    @BeforeEach
    void setUp() {
        accountDTO = new AccountDTO();
        accountDTO.setPassword("password");
        accountDTO.setName("Test Name");
        accountDTO.setEmail("test@email.com");
        accountDTO.setPhone("123-456-7890");
        accountDTO.setNation("Test Nation");
        accountDTO.setHospital("Test Hospital");
        accountDTO.setDepartment("Test Department");
    }

    @Test
    void testSignUpAccount() throws JsonProcessingException {
        //log.info("AccountDTO: {}", accountSignUpDTO);
        accountService.signUpAccount(accountDTO);
        UUID uuid = accountDTO.getUuid();
        AccountEntity accountEntity = accountEntityRepository.findByUuid(uuid)
        .orElseThrow(() -> new NoSuchElementException("AccountEntity not found with UUID: " + uuid));
        
        AccountClassificationEntity accountClassificationEntity = accountClassificationEntityRepository.findByUuid(uuid)
        .orElseThrow(() -> new NoSuchElementException("accountClassificationEntity not found with UUID: " + uuid));
        
        ApiResponse<AccountResponse> apiResponse = ApiResponse.ok(AccountResponse.toResponse(accountEntity, accountClassificationEntity));
        log.info(apiResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(apiResponse);
        log.info(jsonResponse);
        jsonResponse = objectMapper.writeValueAsString(apiResponse.getData());
        log.info(jsonResponse);
    }
}
