package inflearn.yh.course2.web.frontcontroller.v2.controller;

import inflearn.yh.course2.web.frontcontroller.MyView;
import inflearn.yh.course2.web.frontcontroller.v2.ControllerV2;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFormControllerV2 implements ControllerV2 {

    @Override
    public MyView
    process(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        return new MyView("/WEB-INF/views/new-form.jsp");
    }

}
