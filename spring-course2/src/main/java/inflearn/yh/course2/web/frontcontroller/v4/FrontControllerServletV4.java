package inflearn.yh.course2.web.frontcontroller.v4;

import inflearn.yh.course2.web.frontcontroller.ModelView;
import inflearn.yh.course2.web.frontcontroller.MyView;
import inflearn.yh.course2.web.frontcontroller.v4.ControllerV4;
import inflearn.yh.course2.web.frontcontroller.v4.controller.MemberFormControllerV4;
import inflearn.yh.course2.web.frontcontroller.v4.controller.MemberListControllerV4;
import inflearn.yh.course2.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {


    private Map<String, ControllerV4> controllerMap = new HashMap<>();
    private final String prefix = "/WEB-INF/views/";
    private final String surfix = ".jsp";

    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("FrontControllerServletV4.service");

        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        ControllerV4 controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);

        Map<String, Object> model = new HashMap<>();
        String viewName = controller.process(paramMap, model);

        MyView view = viewResolver(viewName);

        view.render(model, request, response);
    }

    private MyView viewResolver(String viewName) {
        return new MyView(prefix + viewName + surfix);
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
            .forEachRemaining(
                paramName -> paramMap.put(paramName, request.getParameter(paramName)));

        return paramMap;
    }
}
