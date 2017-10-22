package nl.necrotigr.converter.model.dto;

import com.google.api.client.util.Key;
import lombok.Data;
import nl.necrotigr.converter.model.Currency;
import nl.necrotigr.converter.model.ExchangeRate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Data
public class FixedIoExRateData implements ExRateData {

    @Key
    private String base;

    @Key
    private String date;

    @Key
    private Map<String, BigDecimal> rates;

    @Override
    public ExchangeRate toExchangeRate(Currency currency) {
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setBaseCurrency(Currency.valueOf(base));
        exchangeRate.setDate(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        exchangeRate.setCurrency(currency);
        exchangeRate.setPrice(rates.get(currency.getCode()));
        return exchangeRate;
    }
}
