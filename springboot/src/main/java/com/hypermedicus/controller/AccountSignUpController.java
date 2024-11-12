package com.hypermedicus.controller;

import com.hypermedicus.model.AccountSignUpDTO;
import com.hypermedicus.service.AccountSignUpService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signup")
public class AccountSignUpController {

    private final AccountSignUpService accountSignUpService;

    public AccountSignUpController(AccountSignUpService accountSignUpService) {
        this.accountSignUpService = accountSignUpService;
    }

    @PostMapping
    public void signUpAccount(@RequestBody AccountSignUpDTO dto) {
        accountSignUpService.signUpAccount(dto);
    }
}
