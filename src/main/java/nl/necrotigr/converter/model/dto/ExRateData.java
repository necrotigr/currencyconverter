package nl.necrotigr.converter.model.dto;

import nl.necrotigr.converter.model.Currency;
import nl.necrotigr.converter.model.ExchangeRate;

public interface ExRateData {

    ExchangeRate toExchangeRate(Currency currency);
}
