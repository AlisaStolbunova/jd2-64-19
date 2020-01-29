//package by.it.academy.project;
//import by.it.academy.project.entity.*;
//import by.it.academy.project.util.HibernateUtil;
//import org.hibernate.Session;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class Relations {
//    public static void main(String[] args) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//
//        Department department = new Department("project_office");
//        session.save(department);
//
//        Employee e = new Employee(null, "Petr", "Vasechkin", LocalDateTime.now(), null, null, null);
//
//        EmployeeDetail detail = new EmployeeDetail(null, "Karolinskaya", "Minsk", "state", "Belarus", null);
//        e.setEmployeeDetail(detail);
//        detail.setEmployee(e);
//        session.save(detail);
//
//        Meeting meeting = new Meeting("Hibernate relation grooming");
//        List<Meeting> m = new ArrayList<>();
//        m.add(meeting);
//        e.setMeetings(m);
//
//        session.saveOrUpdate(e);
//
//        session.getTransaction().commit();
//        session.close();
//        HibernateUtil.shutdown();
//    }
//}
