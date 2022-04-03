package com.hello.typeconverter;

import com.hello.typeconverter.converter.IpPortToStringConverter;
import com.hello.typeconverter.converter.StringToIpPortConverter;
import com.hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // converter가 우선순위가 더 높음.
//        registry.addConverter(new IntegerToStringConverter());
//        registry.addConverter(new StringToIntegerConverter());

        registry.addConverter(new IpPortToStringConverter());
        registry.addConverter(new StringToIpPortConverter());

        registry.addFormatter(new MyNumberFormatter());

    }
}
