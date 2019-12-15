package by.it.academy.epolyclinic.Servlet;

import by.it.academy.epolyclinic.model.User;
import by.it.academy.epolyclinic.service.ProductService;
import by.it.academy.epolyclinic.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private ProductService productService = ProductServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        if(userName == null || password == 0 || userName.length() == 0 || password.length()==0){
            req.setAttribute("errorMessage","user name and password should be");
            req.setAttribute();
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
        }

        User user = service.getUser(userName, password);

        if(user != null){
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect(req.getContextPath()+ "/home");
        }
        else{
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }

    }
}
