package com.ing.account.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ing.account.domain.types.AccountType;
import com.ing.account.domain.types.Currency;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class AccountDTO implements Serializable {

    private String iban;
    private BigDecimal ammount;
    private String owner;

    @JsonProperty
    @NotNull
    private Currency currency;

    @JsonProperty
    @NotNull
    private AccountType type;

    public AccountDTO() {
    }

    public AccountDTO(String iban, BigDecimal ammount, String owner, @NotNull Currency currency, @NotNull AccountType type) {
        this.iban = iban;
        this.ammount = ammount;
        this.owner = owner;
        this.currency = currency;
        this.type = type;
    }

    @JsonProperty
    public String getIban() {
        return iban;
    }

    @JsonIgnore
    public void setIban(String iban) {
        this.iban = iban;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @JsonProperty
    public BigDecimal getAmmount() {
        return ammount;
    }

    @JsonIgnore
    public void setAmmount(BigDecimal ammount) {
        this.ammount = ammount;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
