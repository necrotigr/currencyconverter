package nl.necrotigr.converter;

import nl.necrotigr.converter.model.Currency;
import nl.necrotigr.converter.model.ExchangeRate;
import nl.necrotigr.converter.service.FixedIoSimpleRetriever;
import nl.necrotigr.converter.service.RateRetriever;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        RateRetriever rateRetriever = new FixedIoSimpleRetriever();

        ExchangeRate rate = rateRetriever.getRate(LocalDate.now(), Currency.RUB, Currency.EUR);
        System.out.println(rate);
    }
}
