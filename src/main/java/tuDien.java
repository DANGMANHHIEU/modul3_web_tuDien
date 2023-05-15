import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet (name="servlet", value = "/aaa")
public class tuDien extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");

        String search = req.getParameter("search");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter writer= resp.getWriter();
        writer.println("<html><meta charset=UTF-8>");
//        writer.println("<head>");
//        writer.println("<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /></head>");
//        writer.println("</head>");
        String result = dictionary.get(search);
        if(result != null){
            writer.println("Word: "+ search);
            writer.println("<br/>");
            writer.println("Result: " +  result);
        }
        else {
            writer.println("Not found");
        }
        writer.println("</html> ");

    }
}
