package by.it.academy.epolyclinic.servlet;

import by.it.academy.clinic.Doctor;
import by.it.academy.clinic.User;
import by.it.academy.service.DoctorService;
import by.it.academy.service.DoctorServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/doctorCreate")
public class DoctorCreateServlet extends HttpServlet {

    private DoctorService doctorService = DoctorServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if ("admin".equals(user.getRole())){
            req.getRequestDispatcher("/WEB-INF/doctorCreate.jsp").forward(req,resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String post = req.getParameter("post");
        String department = req.getParameter("department");
        String section = req.getParameter("section");
        String office = req.getParameter("office");
        String phoneNumber = req.getParameter("phoneNumber");

        Doctor doctor = new Doctor(null, name, post, department, Integer.valueOf(section),
                Integer.valueOf(office), phoneNumber);

        doctorService.addNewDoctor(doctor);

        resp.sendRedirect(req.getContextPath() + "/doctorsList");


    }
}
