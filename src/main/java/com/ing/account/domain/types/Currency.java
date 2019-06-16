package com.ing.account.domain.types;

public enum Currency {

    USD("US dollar"),
    EUR("Euro"),
    RON("Romanian leu");

    private String key;

    Currency(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
