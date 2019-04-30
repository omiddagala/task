package com.mobilab.accounting.web.utils.currency;

import com.mobilab.accounting.web.model.CurrencyType;

public class CurrencyFactory {

    public static CurrencyConverter getCurrencyFactory(CurrencyType destinationType) {
        if (CurrencyType.USD.equals(destinationType)) {
            return new CurrencyToDollarConverter();
        }
        return new CurrencyToEuroConverter();
    }
}
