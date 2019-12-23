package by.it.academy.epolyclinic.servlet;

import by.it.academy.service.DoctorService;
import by.it.academy.service.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doctorDelete")
public class DoctorDeleteServlet extends HttpServlet {

    private DoctorService doctorService = DoctorServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doctorService.deleteDoctor(Long.parseLong(req.getParameter("id")));

        resp.sendRedirect(req.getContextPath() + "/doctorsList");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        doctorService.deleteDoctor(Long.parseLong(req.getParameter("id")));

        resp.sendRedirect(req.getContextPath() + "/doctorsList");
    }

}
