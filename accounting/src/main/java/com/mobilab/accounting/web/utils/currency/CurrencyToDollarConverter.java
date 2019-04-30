package com.mobilab.accounting.web.utils.currency;

import com.mobilab.accounting.web.model.CurrencyType;

public class CurrencyToDollarConverter implements CurrencyConverter {

    @Override
    public Double convert(CurrencyType sourceCurrency, Double amount) {
        if (CurrencyType.EUR.equals(sourceCurrency)){
            return amount * 1.36077;
        }
        return amount;
    }
}
