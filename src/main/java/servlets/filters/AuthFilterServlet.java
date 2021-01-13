package servlets.filters;

import model.User;
import org.hibernate.Session;
import userService.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin/*", "/user/*"})//Защищаемае часть
public class AuthFilterServlet implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String uri = request.getRequestURI();
        HttpSession session =request.getSession();

        if ( session.getAttribute("userLogin") == null || session.getAttribute("userRole").equals("user") && uri.endsWith("/admin/list")) {
            response.sendRedirect("/");
        } else {
            chain.doFilter(req, res);
        }
    }
    @Override
    public void destroy() {

    }
}











