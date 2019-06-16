package com.ing.account.domain.entity;

import com.ing.account.domain.types.AccountType;
import com.ing.account.domain.types.Currency;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "iban", nullable = false)
    private String iban;

    @Column(name = "ammount", nullable = false)
    private BigDecimal ammount;

    @Column(name = "ownerEmail", nullable = false)
    private String ownerEmail;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private AccountType type;

    public Account() {
    }

    public Account(String iban, BigDecimal ammount, String ownerEmail, Currency currency, AccountType type) {
        this.iban = iban;
        this.ammount = ammount;
        this.ownerEmail = ownerEmail;
        this.currency = currency;
        this.type = type;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public BigDecimal getAmmount() {
        return ammount;
    }

    public void setAmmount(BigDecimal ammount) {
        this.ammount = ammount;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }
}
