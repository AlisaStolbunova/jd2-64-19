package by.it.academy.clinic;

import by.it.academy.clinic.dao.DAO;
import by.it.academy.clinic.dao.impl.EmployeeDaoImpl;
import by.it.academy.clinic.entity.Department;
import by.it.academy.clinic.entity.Employee;
import by.it.academy.clinic.entity.EmployeeDetail;
import by.it.academy.clinic.entity.Meeting;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;

public class SpringHiberMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = null;
        try {
            context = new ClassPathXmlApplicationContext("spring-hiber.xml");
            DAO employeeDao = context.getBean("employeeDaoImpl", EmployeeDaoImpl.class);

            Employee employee = new Employee();
            Meeting meeting = new Meeting("election");
            meeting.setEmployees(Collections.singletonList(employee));
            Department department = new Department("marketing");
            department.setEmployees(Collections.singleton(employee));
            EmployeeDetail employeeDetail = new EmployeeDetail();
            employeeDetail.setEmployee(employee);
            employeeDetail.setCity("Minsk");
            employeeDetail.setCountry("Belarus");
            employeeDetail.setState("Minsk Obl");
            employeeDetail.setStreet("Karolinskaya");
//
            employee.setDepartment(department);
            employee.setEmployeeDetail(employeeDetail);
            employee.setFirstName("Alisa");
            employee.setLastName("Stolbunova");
            employee.setMeetings(Collections.singletonList(meeting));

            Employee persistedEmployee = (Employee) employeeDao.add(employee);

            System.out.println(employeeDao.get(persistedEmployee.getId()));
        } finally {
            if (context != null) {
                context.close();
            }
        }
    }
}
