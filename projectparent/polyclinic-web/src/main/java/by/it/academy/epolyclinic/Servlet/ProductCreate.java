package by.it.academy.epolyclinic.Servlet;

import by.it.academy.epolyclinic.model.Product;
import by.it.academy.epolyclinic.service.ProductService;
import by.it.academy.epolyclinic.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/productCreate")
public class ProductCreate extends HttpServlet {

    private ProductService productService = ProductServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/productCreate.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String price = req.getParameter("price");

        Product product = new Product(null, name, Double.valueOf(price));

        productService.addNewProduct(product);

        resp.sendRedirect(req.getContextPath() + "/productList");
    }
}
