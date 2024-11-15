package com.hypermedicus.controller;

import com.hypermedicus.model.AccountDTO;
import com.hypermedicus.payload.response.AccountResponse;
import com.hypermedicus.payload.response.ApiResponse;
import com.hypermedicus.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account/signup")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ApiResponse<AccountResponse> signUpAccount(@RequestBody AccountDTO dto) {
        AccountResponse accountResponse = accountService.signUpAccount(dto);
        return ApiResponse.ok(accountResponse);
    }
}
