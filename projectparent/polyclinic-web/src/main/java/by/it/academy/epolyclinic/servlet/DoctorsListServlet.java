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
import java.util.List;

@WebServlet("/doctorsList")
public class DoctorsListServlet extends HttpServlet {
    private DoctorService doctorService = DoctorServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Doctor> allDoctors = doctorService.getAllDoctors();

        req.setAttribute("doctorsList", allDoctors);
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("role", user.getRole());
        req.getRequestDispatcher("/WEB-INF/doctors.jsp").forward(req,resp);
    }
}
