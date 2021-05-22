package inflearn.yh.course2.basic.response;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.jfr.ContentType;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy.Content;
import org.springframework.http.MediaType;

@WebServlet(name = "responseHtmlServlet", urlPatterns = "/response-html")
public class ResponseHtmlServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType(MediaType.TEXT_HTML_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());

        String htmlBody = createHtmlForm();

        response.getWriter().println(htmlBody);
    }

    private String createHtmlForm() {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html>");
        htmlBuilder.append("<body>");
        htmlBuilder.append("<div>안녕?</div>");
        htmlBuilder.append("</body>");
        htmlBuilder.append("</html>");
        return htmlBuilder.toString();
    }


}
