package by.it.academy.clinic;

import by.it.academy.clinic.entity.Department;
import by.it.academy.clinic.entity.Employee;
import by.it.academy.clinic.entity.EmployeeDetail;
import by.it.academy.clinic.entity.Meeting;
import by.it.academy.clinic.service.DepartmentService;
import by.it.academy.clinic.service.EmployeeService;
import by.it.academy.clinic.service.MeetingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

public class SpringHiberMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = null;
        try {
            context = new ClassPathXmlApplicationContext("spring-hiber.xml");
            EmployeeService employeeService = context.getBean(EmployeeService.class);
            DepartmentService departmentService = context.getBean(DepartmentService.class);
            MeetingService meetingService = context.getBean(MeetingService.class);
            meetingService.addAll(Arrays.asList(
                    new Meeting("election"),
                    new Meeting("discussion"),
                    new Meeting("election")));
            LocalDateTime startDate = LocalDateTime.now();
            Employee employee = new Employee();
            Meeting meetingElection = new Meeting("election");
            meetingElection.setEmployees(Collections.singletonList(employee));
            Department department = new Department("marketing");
            department.setEmployees(Collections.singleton(employee));
            EmployeeDetail employeeDetail = new EmployeeDetail();
            employeeDetail.setEmployee(employee);
            employeeDetail.setCity("Minsk");
            employeeDetail.setCountry("Belarus");
            employeeDetail.setState("Minsk Obl");
            employeeDetail.setStreet("Karolinskaya");

            employee.setDepartment(department);
            employee.setEmployeeDetail(employeeDetail);
            employee.setFirstName("Alisa");
            employee.setLastName("Stolbunova");
            employee.setMeetings(Collections.singletonList(meetingElection));

            Employee persistedEmployee = employeeService.add(employee);
            System.out.println(employeeService.get(persistedEmployee.getId()));
            System.out.println(departmentService.findByName("marketing"));
            meetingService.findBySubject("election").forEach(System.out::println);
            meetingService.findBySubjectOrderByStartDate("election").forEach(System.out::println);
            meetingService.findByStartDateBetween(startDate, LocalDateTime.now()).forEach(System.out::println);
        } finally {
            if (context != null) {
                context.close();
            }
        }
    }

    private static Iterable<Department> initDepartments(ApplicationContext context){
        DepartmentService departmentService = context.getBean(DepartmentService.class);
        return departmentService.add(Arrays.asList(new Department("marketing"), new Department("sales")));
    }

    private static void initEmployee(ApplicationContext context){

    }
}
