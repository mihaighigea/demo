package com.ing.account.domain.types;

import java.util.Arrays;

public enum AccountType {
    SAVINGS("Savings account");

    private String value;

    AccountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AccountType labelOf(String value) {
        return Arrays.stream(AccountType.values())
            .filter(item -> item.value.contains(value))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("Invalid value provided"));
    }
}
