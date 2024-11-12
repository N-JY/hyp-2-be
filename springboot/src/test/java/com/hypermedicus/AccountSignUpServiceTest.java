package com.hypermedicus;

import com.hypermedicus.model.AccountSignUpDTO;
import com.hypermedicus.service.AccountSignUpService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountSignUpServiceTest {

    @Autowired
    private AccountSignUpService accountSignUpService;

    private AccountSignUpDTO accountSignUpDTO;

    @BeforeEach
    void setUp() {
        accountSignUpDTO = new AccountSignUpDTO();
        accountSignUpDTO.setPassword("password");
        accountSignUpDTO.setName("Test Name");
        accountSignUpDTO.setEmail("test@email.com");
        accountSignUpDTO.setPhone("123-456-7890");
        accountSignUpDTO.setNation("Test Nation");
        accountSignUpDTO.setHospital("Test Hospital");
        accountSignUpDTO.setDepartment("Test Department");
    }

    @Test
    void testSignUpAccount() {
        accountSignUpService.signUpAccount(accountSignUpDTO);
    }
}
