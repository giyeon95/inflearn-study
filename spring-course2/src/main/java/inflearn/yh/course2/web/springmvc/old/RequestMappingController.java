package inflearn.yh.course2.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@RequestMapping("/springmvc")
public class RequestMappingController {

    @RequestMapping(value = "/old-controller", method = RequestMethod.GET)
    public String test() {
        System.out.println("NewController.test");
        return "members";
    }

}
