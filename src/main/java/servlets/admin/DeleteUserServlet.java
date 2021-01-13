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

@WebServlet("/admin/delete")
public class DeleteUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            Long id = Long.parseLong(req.getParameter("id"));
            try {
                UserService.getInstance().deleteUser(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.getRequestDispatcher("/admin").forward(req, res);

        }
    }

