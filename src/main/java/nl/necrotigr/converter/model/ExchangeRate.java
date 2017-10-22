package nl.necrotigr.converter.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExchangeRate {

    private Currency currency;
    private Currency baseCurrency;
    private LocalDate date;
    private BigDecimal price;

}
