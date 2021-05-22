package inflearn.yh.course2.web.frontcontroller.v1.controller;

import inflearn.yh.course2.domain.member.Member;
import inflearn.yh.course2.domain.member.MemberRepository;
import inflearn.yh.course2.web.frontcontroller.v1.ControllerV1;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberListControllerV1 implements ControllerV1 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        List<Member> members = memberRepository.findAll();
        request.setAttribute("members", members);

        String viewPath = "/WEB-INF/views/members.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);

        dispatcher.forward(request, response);
    }
}
