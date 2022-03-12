package hello.login.web;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import hello.login.domain.member.Member;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class SessionManagerTest {

    private  SessionManager sessionManager = new SessionManager();

    private Member member;

    private MockHttpServletRequest request;

    @BeforeEach
    void init() {
        this.sessionManager = new SessionManager();
        this.member = new Member();
        request = new MockHttpServletRequest();

        MockHttpServletResponse response = new MockHttpServletResponse();
        sessionManager.createSession(this.member, response);

        request.setCookies(response.getCookies());
    }

    @Test
    void getSessionTest() {
        Object session = sessionManager.getSession(request)
            .orElseThrow(RuntimeException::new);

        assertThat(session).isEqualTo(member);
    }

    @Test
    void expireTest() {
        sessionManager.expire(request);
        assertThat(sessionManager.getSession(request)).isEmpty();
    }
}