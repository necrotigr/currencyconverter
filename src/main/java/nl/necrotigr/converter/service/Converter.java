package nl.necrotigr.converter.service;

import nl.necrotigr.converter.model.Currency;

import java.math.BigDecimal;

public interface Converter {


    BigDecimal convert(Currency baseCurrency, Currency targetCurrency, BigDecimal baseAmount);

}
