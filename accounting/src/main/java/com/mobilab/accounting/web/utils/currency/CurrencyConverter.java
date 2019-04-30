package com.mobilab.accounting.web.utils.currency;

import com.mobilab.accounting.web.model.CurrencyType;

public interface CurrencyConverter {

    Double convert(CurrencyType sourceCurrency, Double amount);

}
