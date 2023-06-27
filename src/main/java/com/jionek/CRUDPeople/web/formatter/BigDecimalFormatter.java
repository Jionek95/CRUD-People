package com.jionek.CRUDPeople.web.formatter;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Component
public class BigDecimalFormatter implements Formatter<BigDecimal> {


    @Override
    public BigDecimal parse(String text, Locale locale) throws ParseException {
        String valueWithCurrency = NumberFormat.getCurrencyInstance(locale).parse(text).toString();
        BigDecimal.valueOf(Double.parseDouble(valueWithCurrency));
        return null;
    }

    @Override
    public String print(BigDecimal object, Locale locale) {
        return NumberFormat.getCurrencyInstance(locale).format(object);
    }
}
