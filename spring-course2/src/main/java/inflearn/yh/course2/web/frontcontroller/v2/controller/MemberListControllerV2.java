package inflearn.yh.course2.web.frontcontroller.v2.controller;

import inflearn.yh.course2.domain.member.Member;
import inflearn.yh.course2.domain.member.MemberRepository;
import inflearn.yh.course2.web.frontcontroller.MyView;
import inflearn.yh.course2.web.frontcontroller.v2.ControllerV2;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberListControllerV2 implements ControllerV2 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        List<Member> members = memberRepository.findAll();
        request.setAttribute("members", members);

        return new MyView("/WEB-INF/views/members.jsp");
    }
}
