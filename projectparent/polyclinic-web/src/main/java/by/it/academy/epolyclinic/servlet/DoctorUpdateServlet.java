package by.it.academy.epolyclinic.servlet;

import by.it.academy.clinic.Doctor;
import by.it.academy.service.DoctorService;
import by.it.academy.service.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doctorUpdate")
public class DoctorUpdateServlet extends HttpServlet {

    private DoctorService doctorService = DoctorServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String post = req.getParameter("post");
        String department = req.getParameter("department");
        String section = req.getParameter("section");
        String office = req.getParameter("office");
        String phoneNumber = req.getParameter("phoneNumber");

        Doctor doctor = new Doctor(Long.parseLong(id), name, post, department, Integer.parseInt(section),
                Integer.parseInt(office), phoneNumber);

        doctorService.updateDoctor(doctor);
        resp.sendRedirect(req.getContextPath() + "/doctorsList");


    }
}
