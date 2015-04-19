import com.Data.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dodd on 2015/4/19.
 */
public class RegClass extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("/regS.jsp");
        try {
            System.out.println("age:" + req.getParameter("age"));
            new DAO().userReg(req.getParameter("username"), req.getParameter("tel"), req.getParameter("email"), Integer.valueOf(req.getParameter("age")), req.getParameter("pswd"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        view.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
