package by.it.academy.epolyclinic.filter;

import by.it.academy.epolyclinic.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(value = "/*", dispatcherTypes = DispatcherType.REQUEST)
public class AuthFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
      User user = (User) req.getSession().getAttribute("user");
      if(user != null){
          super.doFilter(req, res, chain);
      }
      else{
          req.getRequestDispatcher("/")
      }


    }
}
