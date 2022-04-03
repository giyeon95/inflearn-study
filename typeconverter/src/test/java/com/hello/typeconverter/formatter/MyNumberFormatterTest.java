package com.hello.typeconverter.formatter;

import static org.assertj.core.api.Assertions.*;

import java.text.ParseException;
import java.util.Locale;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MyNumberFormatterTest {

    private MyNumberFormatter formatter = new MyNumberFormatter();

    @Test
    void parseTest() throws ParseException {
        Number result = formatter.parse("1,000", Locale.KOREA);
        assertThat(result).isEqualTo(1000L);
    }

    @Test
    void print() {
        String result = formatter.print(1000, Locale.KOREA);
        System.out.println(formatter.print(1000, Locale.CANADA));
        System.out.println(formatter.print(1000, Locale.ENGLISH));
        System.out.println(formatter.print(1000, Locale.CHINESE));
        System.out.println(formatter.print(1000, Locale.GERMAN));
        System.out.println(formatter.print(1000, Locale.JAPAN));
        System.out.println(formatter.print(1000, Locale.ITALIAN));
        System.out.println(formatter.print(1000, Locale.US));

        assertThat(result).isEqualTo("1,000");
    }
}