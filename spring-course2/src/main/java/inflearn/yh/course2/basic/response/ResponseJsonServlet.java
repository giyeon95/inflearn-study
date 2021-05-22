package inflearn.yh.course2.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import inflearn.yh.course2.basic.HelloData;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());

        HelloData helloData = new HelloData();
        helloData.setUsername("김기연");
        helloData.setAge(27);

        String result = objectMapper.writeValueAsString(helloData);

        response.getWriter().write(result);
    }
}
