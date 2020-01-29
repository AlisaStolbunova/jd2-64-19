package by.it.academy.project;

import by.it.academy.project.entity.Department;
import by.it.academy.project.entity.Employee;
import by.it.academy.project.entity.EmployeeDetail;
import by.it.academy.project.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.LocalDateTime;
import java.util.List;

@Slf4j
public class HQL {
    public static void main(String[] args) {


        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        Employee e = new Employee(null, "Alisa", "Stolbunova",
                LocalDateTime.now(), null, null);
        Department d = new Department("project_office");
        EmployeeDetail detail = new EmployeeDetail(null, "Karolinskaya", "Minsk", "state", "Belarus", null);
        e.setEmployeeDetail(detail);
        detail.setEmployee(e);
        session.save(d);
        session.save(detail);
        session.saveOrUpdate(e);

        Employee e1 = new Employee(null, "Olga", "Poyarkova",
                LocalDateTime.now(), null, null);
        Department d1 = new Department("lawyers");
        EmployeeDetail detail1 = new EmployeeDetail(null, "Prushinskih", "Minsk", "state", "Belarus", null);
        e1.setEmployeeDetail(detail1);
        detail1.setEmployee(e1);
        session.save(d1);
        session.save(detail1);
        session.saveOrUpdate(e1);

        session.getTransaction().commit();
        session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();


        Query<Employee> q1 = session.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = q1.list();

        Query<Employee> q2 = session.createQuery("select e.firstName, e.lastName from Employee as e where e.department.departmentName = 'lawyers'");
        List<Employee> employees1 = q2.getResultList();

        session.getTransaction().commit();
        session.close();


        HibernateUtil.shutdown();

    }
}
