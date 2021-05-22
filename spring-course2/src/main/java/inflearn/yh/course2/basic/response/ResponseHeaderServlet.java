package inflearn.yh.course2.basic.response;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

//        response.setStatus(HttpServletResponse.SC_OK);

        setHeaderContents(response);
        setCookie(response);
        setRedirect(response);

        response.setHeader("Cache-Control", "no-cache, not-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");


        response.getWriter().println("ok");
    }

    private void setRedirect(HttpServletResponse response) throws IOException {
//        response.setStatus(HttpServletResponse.SC_FOUND); // 302
//        response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }

    private void setCookie(HttpServletResponse response) {
        Cookie myCookie = new Cookie("myCookie", "good");
        myCookie.setMaxAge(600);
        response.addCookie(myCookie);
    }

    private void setHeaderContents(HttpServletResponse response) {
        response.setContentType(MediaType.TEXT_PLAIN_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
    }

}
