import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@WebServlet (value = "/time")
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String timezone = req.getParameter("timezone");
        if (timezone == null || timezone.isEmpty()){
            timezone = "UTC";
        } else {
            timezone = timezone.trim().replace(" ", "+");
        }

        resp.setContentType("text/html; charset=utf-8");

        resp.getWriter().write("<h2>" + getFormattedDateTime(timezone) +"</h2>");
        resp.getWriter().close();
    }

    private String getFormattedDateTime(String timezone){
        ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.of(timezone));
       return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " " + timezone;
    }
}
