package com.ing.account.controller;

import com.ing.account.domain.dto.AccountDTO;
import com.ing.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(
        method = RequestMethod.POST,
        consumes = APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<?> addSavingsAccount(@Valid @RequestBody AccountDTO account) {
        return accountService.create(account);
    }

    @RequestMapping(
        method = RequestMethod.GET,
        produces = APPLICATION_JSON_UTF8_VALUE
    )
    @PreAuthorize("isAccessBetweenWorkingHours()")
    public ResponseEntity<?> getAccounts() {
        return accountService.get();
    }
}

