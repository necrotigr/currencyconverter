package nl.necrotigr.converter.service;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import nl.necrotigr.converter.model.Currency;
import nl.necrotigr.converter.model.ExchangeRate;
import nl.necrotigr.converter.model.dto.FixedIoExRateData;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FixedIoSimpleRetriever implements RateRetriever {

    public static final String BASE_URL = "http://api.fixer.io/";

    static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    static final JsonFactory JSON_FACTORY = new JacksonFactory();

    @Override
    public ExchangeRate getRate(LocalDate date, Currency currency, Currency baseCurrency) {

        HttpRequestFactory requestFactory =
                HTTP_TRANSPORT.createRequestFactory(request -> request.setParser(new JsonObjectParser(JSON_FACTORY)));
        try {
            HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(getUrlString(date, baseCurrency)));

            FixedIoExRateData jsonData = request.execute().parseAs(FixedIoExRateData.class);
            return jsonData.toExchangeRate(currency);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    private String getUrlString(LocalDate date, Currency base) {
        return BASE_URL + date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "?base=" + base.getCode();
    }

    @Override
    public List<ExchangeRate> getRates(LocalDate from, LocalDate to, Currency currency, Currency baseCurrency) {
        return null;
    }
}
