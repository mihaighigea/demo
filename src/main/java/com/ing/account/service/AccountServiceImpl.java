package com.ing.account.service;

import com.ing.account.domain.dto.AccountDTO;
import com.ing.account.domain.entity.Account;
import com.ing.account.domain.types.AccountType;
import com.ing.account.error.ErrorResponsePayload;
import com.ing.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository repository;

    private final BigDecimal initialAmmount;

    @Autowired
    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
        this.initialAmmount = new BigDecimal(0);
    }

    @Override
    public ResponseEntity<?> get() {
        Iterable<Account> persistedAccounts;
        try {
            persistedAccounts = repository.findAll();
        } catch (Exception e) {
            // log exception
            return new ResponseEntity<>(new ErrorResponsePayload("There was an error while processing your request."),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        List<AccountDTO> accounts = StreamSupport.stream(persistedAccounts.spliterator(), true)
                .map((item) ->new AccountDTO(
                    item.getIban(),
                    item.getAmmount(),
                    item.getOwnerEmail(),
                    item.getCurrency(),
                    item.getType())
                ).collect(Collectors.toList());

        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> create(AccountDTO account) {
        // Check if already exists a savings account
        List<Account> accounts = repository.findAccountsByType(AccountType.SAVINGS);
        if (!accounts.isEmpty()) {
            return new ResponseEntity<>(new ErrorResponsePayload("Saving account already exists."),
                    HttpStatus.BAD_REQUEST);
        }

        // try save savings account
        try {
            repository.save(new Account(
                    newIban(),
                    initialAmmount,
                    getOwnerFromSessionOrJWT(),
                    account.getCurrency(),
                    account.getType()
            ));
        } catch (Exception e) {
            // log exception
            return new ResponseEntity<>(new ErrorResponsePayload("There was an error while processing your request."),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private String newIban() {
        return "UniqueGeneratedIban";
    }

    private String getOwnerFromSessionOrJWT() {
        return "john@example.com";
    }
}
