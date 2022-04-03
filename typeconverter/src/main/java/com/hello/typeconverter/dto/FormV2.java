package com.hello.typeconverter.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public record FormV2(
    @NumberFormat(pattern = "###,###")
    Integer number,

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime localDateTime

) {

    @Builder
    public FormV2 {

    }
}