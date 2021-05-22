package inflearn.yh.course2.web.frontcontroller.v5.adapter;

import inflearn.yh.course2.web.frontcontroller.ModelView;
import inflearn.yh.course2.web.frontcontroller.MyView;
import inflearn.yh.course2.web.frontcontroller.v3.ControllerV3;
import inflearn.yh.course2.web.frontcontroller.v4.ControllerV4;
import inflearn.yh.course2.web.frontcontroller.v5.MyHandlerAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerAHandlerAdapterV4 implements MyHandlerAdapter {

    private final String prefix = "/WEB-INF/views/";
    private final String surfix = ".jsp";


    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse responsae,
        Object handler) throws ServletException, IOException {
        ControllerV4 controller = (ControllerV4) handler;

        Map<String, String> paramMap = createParamMap(request);
        HashMap<String, Object> model = new HashMap<>();

        String viewName = controller.process(paramMap, model);

        ModelView mv = new ModelView(viewName);
        mv.setModel(model);

        return mv;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
            .forEachRemaining(
                paramName -> paramMap.put(paramName, request.getParameter(paramName)));

        return paramMap;
    }

}
