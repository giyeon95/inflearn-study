package hello.login.web.session;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SessionInfoController {


    @GetMapping("/session-info")
    public String sessionInfo(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            return "Session not exist.";
        }
        session.getAttributeNames().asIterator()
            .forEachRemaining(
                name -> log.info("session name={}, value={}", name, session.getAttribute(name)));

        log.info("sessionId={}", session.getId());
        log.info("getMaxInactiveInterval={}", session.getMaxInactiveInterval());
        log.info("getCreationTime={}",
            LocalDateTime.ofInstant(Instant.ofEpochMilli(session.getCreationTime()),
                TimeZone.getDefault().toZoneId()));
        log.info("getLastAccessedTime={}",
            LocalDateTime.ofInstant(Instant.ofEpochMilli(session.getLastAccessedTime()),
                TimeZone.getDefault().toZoneId()));
        log.info("isNew={}", session.isNew());

        return "Session Info See Log";
    }
}
