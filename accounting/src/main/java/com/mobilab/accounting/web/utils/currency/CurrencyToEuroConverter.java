package com.mobilab.accounting.web.utils.currency;

import com.mobilab.accounting.web.model.CurrencyType;

public class CurrencyToEuroConverter implements CurrencyConverter {

    @Override
    public Double convert(CurrencyType sourceCurrency, Double amount) {
        if (CurrencyType.USD.equals(sourceCurrency)) {
            return amount * 0.734878;
        }
        return amount;
    }
}
