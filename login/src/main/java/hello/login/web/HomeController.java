package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;
    private final SessionManager sessionManager;

    //    @GetMapping
    public String homeLogin(
        @CookieValue(name = "memberId", required = false) Long memberId,
        Model model
    ) {

        if (memberId == null) {
            return "home";
        }

        Member loginMember = memberRepository.findById(memberId);

        if (loginMember == null) {
            return "home";
        }

        model.addAttribute("member", loginMember);

        return "loginHome";
    }

    @GetMapping
    public String homeLoginV2(
        HttpServletRequest request,
        Model model
    ) {

        Optional<Object> session = sessionManager.getSession(request);

        if (session.isEmpty()) {
            return "home";
        }

        Member member = (Member) session.get();
        model.addAttribute("member", member);

        return "loginHome";
    }
}