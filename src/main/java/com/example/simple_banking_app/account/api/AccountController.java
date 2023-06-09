package com.example.simple_banking_app.account.api;

import com.example.simple_banking_app.account.api.dto.ExchangeCurrency;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountFacade accountFacade;

    public AccountController(AccountFacade accountFacade) {
        this.accountFacade = accountFacade;
    }

    @PutMapping
    @RequestMapping("/exchangeCurrency/{userPesel}")
    void doTransfer(@RequestBody ExchangeCurrency exchangeCurrency, @PathVariable String userPesel) {
        accountFacade.exchangeCurrency(exchangeCurrency, userPesel);
    }
}