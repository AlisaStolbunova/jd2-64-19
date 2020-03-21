package by.it.academy.epolyclinic.servlet;

import by.it.academy.service.UserService;
import by.it.academy.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        req.getSession(true).setAttribute("clinic.user.Locale", req.getParameter("lang"));
        req.getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        String errorMsg = "";
        boolean hasError = false;

        if (userName == null || userName.length() == 0 || password == null || password.length() == 0) {
            hasError = true;
            errorMsg = "UserName and password should not be empty; ";
        } else {
            userService.createUser(userName, password);
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }
}
