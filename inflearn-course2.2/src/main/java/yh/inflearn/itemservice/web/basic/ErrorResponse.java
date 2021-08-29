package yh.inflearn.itemservice.web.basic;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {

    private final String url;
    private final String message;
    private final LocalDateTime timestamp;
    private final String exception;

}
