package by.it.academy.epolyclinic.tags;

import by.it.academy.clinic.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.jstl.core.ConditionalTagSupport;

public class AuthTag extends ConditionalTagSupport {

    private String path = "";

    @Override
    protected boolean condition() throws JspTagException {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        return user != null && user.getRole().equals("admin");
    }

    public void setPath(String path) {
        this.path = path;
    }
}
