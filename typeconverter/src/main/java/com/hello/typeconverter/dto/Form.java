package com.hello.typeconverter.dto;

import com.hello.typeconverter.type.IpPort;
import lombok.Builder;

public record Form(
    IpPort ipPort
) {

    @Builder
    public Form {
    }
}