package nl.necrotigr.converter.service;


import nl.necrotigr.converter.model.Currency;
import nl.necrotigr.converter.model.ExchangeRate;

import java.time.LocalDate;
import java.util.List;

public interface RateRetriever {

    ExchangeRate getRate(LocalDate date, Currency currency, Currency baseCurrency);

    List<ExchangeRate> getRates(LocalDate from, LocalDate to, Currency currency, Currency baseCurrency);


}
