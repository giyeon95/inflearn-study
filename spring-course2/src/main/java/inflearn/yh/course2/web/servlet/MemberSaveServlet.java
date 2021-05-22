package inflearn.yh.course2.web.servlet;

import inflearn.yh.course2.domain.member.MemberRepository;
import inflearn.yh.course2.domain.member.Member;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("MemberSaveServlet.service");
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        response.setContentType(MediaType.TEXT_HTML_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        PrintWriter writer = response.getWriter();

        writer.write("<html>\n" +
            "<head>\n" +
            " <meta charset=\"UTF-8\">\n" + "</head>\n" +
            "<body>\n" +
            "성공\n" +
            "<ul>\n" +
            "    <li>id=" + member.getId() + "</li>\n" +
            "    <li>username=" + member.getUsername() + "</li>\n" +
            " <li>age=" + member.getAge() + "</li>\n" + "</ul>\n" +
            "<a href=\"/index.html\">메인</a>\n" + "</body>\n" +
            "</html>");
    }
}
