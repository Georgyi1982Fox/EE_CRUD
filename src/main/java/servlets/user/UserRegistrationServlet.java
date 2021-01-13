package servlets.user;

import model.User;
import userService.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

@WebServlet("/register")
public class UserRegistrationServlet extends HttpServlet {
    String role = "";
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
        String userPassword = req.getParameter("password");
        String userEmail = req.getParameter("email");

        if(userName.equals("Georgyi") && userPassword.equals("georgyi")){
            role = "admin";
        }else{
            role = "user";
        }

        User user = new User(userName, userPassword, userEmail,role);
        try {
            UserService.getInstance().addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/");
    }
}