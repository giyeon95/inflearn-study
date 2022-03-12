package hello.login.web.login;

import hello.login.domain.login.LoginService;
import hello.login.domain.member.Member;
import hello.login.web.SessionConst;
import hello.login.web.SessionManager;
import java.util.Optional;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final SessionManager sessionManager;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        return "/login/loginForm";
    }

    public String login(@Valid @ModelAttribute LoginForm form,
        BindingResult bindingResult,
        HttpServletResponse response
    ) {

        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        Optional<Member> loginOpt = loginService.login(form.getLoginId(), form.getPassword());

        if (loginOpt.isEmpty()) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }
        Member member = loginOpt.get();

        response.addCookie(new Cookie("memberId", String.valueOf(member.getId())));

        return "redirect:/";
    }

    public String loginV2(@Valid @ModelAttribute LoginForm form,
        BindingResult bindingResult,
        HttpServletResponse response
    ) {

        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        Optional<Member> loginOpt = loginService.login(form.getLoginId(), form.getPassword());

        if (loginOpt.isEmpty()) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }

        sessionManager.createSession(loginOpt.get(), response);

        return "redirect:/";
    }

    @PostMapping("/login")
    public String loginV3(@Valid @ModelAttribute LoginForm form,
        BindingResult bindingResult,
        HttpServletRequest request
    ) {

        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        Optional<Member> loginOpt = loginService.login(form.getLoginId(), form.getPassword());

        if (loginOpt.isEmpty()) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginOpt.get());

        return "redirect:/";
    }


    public String logout(HttpServletResponse response) {
        expiredCookie(response, "memberId");
        return "redirect:/";
    }

    public String logoutV2(HttpServletRequest request) {
        sessionManager.expire(request);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logoutV3(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }

    private void expiredCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
