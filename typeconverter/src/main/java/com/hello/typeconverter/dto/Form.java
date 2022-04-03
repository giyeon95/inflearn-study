package com.hello.typeconverter.dto;

import com.hello.typeconverter.type.IpPort;
import lombok.Builder;

@Builder
public record Form(
    IpPort ipPort
) {

}