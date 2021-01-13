package servlets.admin;

import model.User;
import userService.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admin/list")
public class AdminServlet extends HttpServlet {
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<User> users = UserService.getInstance().listAllUsers();
            req.setAttribute("users", users);
            req.getRequestDispatcher("/admin.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
