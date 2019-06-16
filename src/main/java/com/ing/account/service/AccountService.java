package com.ing.account.service;

import com.ing.account.domain.dto.AccountDTO;
import org.springframework.http.ResponseEntity;

public interface AccountService {
    ResponseEntity<?> get();

    ResponseEntity<?> create(AccountDTO account);
}
