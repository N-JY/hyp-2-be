package com.hypermedicus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hypermedicus.model.AccountDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class Test_AccountServiceIT {

    @Autowired
    private MockMvc mockMvc;

    private AccountDTO accountDTO;

    @Autowired
    private ObjectMapper objectMapper;

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
    void testSignUpAccount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/account/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(accountDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value("OK"))
                .andExpect(jsonPath("$.data").exists())
                .andDo(result -> {
                    System.out.println("Response: " + result.getResponse().getContentAsString());
                });
    }
}
