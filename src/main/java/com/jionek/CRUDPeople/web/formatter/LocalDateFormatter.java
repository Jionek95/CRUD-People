package com.jionek.CRUDPeople.web.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate>{

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return null;
    }
}
