package com.mobilab.accounting.web.dto;

import com.mobilab.accounting.web.model.CurrencyType;

public class AccountDTO {

    private String name;

    private String accountId;

    private CurrencyType currencyType;

    private Double amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
