package servlets;

import model.User;
import userService.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/")
public class
LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        /*
        String action = req.getParameter("action");
        if (action == null) {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else if (action.equalsIgnoreCase("Logout")) {
            HttpSession session = req.getSession();
            session.removeAttribute("userLogin");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else

         */
            req.getRequestDispatcher("login.jsp").forward(req, resp);

        }

        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
            String userLogin = req.getParameter("login");
            String userPassword = req.getParameter("password");
            String role = "";
            HttpSession session = req.getSession();
            session.setAttribute("userLogin", userLogin);
            session.setAttribute("userPassword", userPassword);
            try {
                if (UserService.getInstance().validateClient(userLogin, userPassword)) {
                    role = UserService.getInstance().getRoleByLoginAndPassword(userLogin, userPassword);
                    session.setAttribute("userRole", role);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (role.equals("user")) {
                resp.sendRedirect("/user");
            } else if (role.equals("admin")) {
                resp.sendRedirect("/admin/list");
            } else
                resp.sendRedirect("/register");
        }
    }









