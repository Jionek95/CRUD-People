package com.jionek.CRUDPeople.business.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;

class PersonTest {

    @Test
    public void canParse(){
        String csvLine = "263265,Ms.,    Annika,D,Coolidge,F,annika.coolidge@shaw.ca,Sterling Coolidge,Loan Coolidge,Eisele,10/31/1971,09:11:17 AM,48.87,51,10/3/2002,Q4,H2,2002,10,   October,Oct,3,Thursday,Thu,17.92,199546,30%,549-99-0159,210-399-4122,Staples,Guadalupe,Staples,TX,78670,South,adcoolidge,Nr#;g4CS";
        Person person = Person.parse(csvLine);
        assertThat(person.getDob()).isEqualTo(LocalDate.of(1971, 10,31));
    }

}