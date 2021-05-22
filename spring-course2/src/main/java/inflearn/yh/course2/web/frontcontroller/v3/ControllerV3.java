package inflearn.yh.course2.web.frontcontroller.v3;

import inflearn.yh.course2.web.frontcontroller.ModelView;
import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);

}
