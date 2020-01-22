package by.it.academy.project;
import by.it.academy.project.entity.*;
import by.it.academy.project.util.HibernateUtil;
import org.hibernate.Session;

import java.time.LocalDateTime;

public class Relations {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession(); session.beginTransaction();
        Employee e = new Employee(null, "Petr", "Vasechkin", LocalDateTime.now(), null);
        EmployeeDetail detail = new EmployeeDetail(null, "Karolinskaya", "Minsk", "state", "Belarus", null);
        e.setEmployeeDetail(detail);
        detail.setEmployee(e);
        session.save(e);
        session.save(detail);
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
