package com.ing.account.repository;

import com.ing.account.domain.entity.Account;
import com.ing.account.domain.types.AccountType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, String> {

    List<Account> findAccountsByType(AccountType type);
}
