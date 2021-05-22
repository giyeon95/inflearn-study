package inflearn.yh.course2.web.frontcontroller.v2;

import inflearn.yh.course2.web.frontcontroller.MyView;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControllerV2 {

    MyView process(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException;

}
