package yh.inflearn.itemservice;

import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import yh.inflearn.itemservice.web.basic.ErrorResponse;

@RestController
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex,
        HttpServletRequest re) {

        return ResponseEntity.ok(ErrorResponse.builder()
            .message(ex.getMessage())
            .timestamp(LocalDateTime.now())
            .exception(ex.getClass().getSimpleName())
            .url(re.getRequestURL().toString())
            .build());
    }
}
