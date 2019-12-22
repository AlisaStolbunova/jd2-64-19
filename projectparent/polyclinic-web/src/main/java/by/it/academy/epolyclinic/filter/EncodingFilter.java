package by.it.academy.epolyclinic.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebFilter("/*")
public class EncodingFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        String lang = req.getParameter("lang");
        if (lang != null){
            req.getSession().setAttribute("locale", new Locale(lang));
        }

        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        super.doFilter(req, res, chain);
    }
}
