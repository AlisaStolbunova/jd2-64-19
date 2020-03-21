package by.it.academy.project;

import by.it.academy.project.DAO.EmployeeDao;
import by.it.academy.project.DAO.EmployeeDaoCriteriaImpl;
import by.it.academy.project.DAO.EmployeeDaoHQLImpl;
import by.it.academy.project.entity.Employee;
import by.it.academy.project.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

@Slf4j
public class HQL {

    private static final EmployeeDao empl = EmployeeDaoHQLImpl.getINSTANCE();

    public static void main(String[] args) {
        try {
            Criteria.init();
            List<Employee> employees = empl.getAll();
            employees.forEach(System.out::println);
            System.out.println();
            List<Employee> emplGetByName = empl.getByName("Ivan");
            emplGetByName.forEach(System.out::println);
            System.out.println();
            List<Employee> emplAllWithNameNotNull = empl.getAllWithNameNotNull();
            emplAllWithNameNotNull.forEach(System.out::println);
            System.out.println();
            List<Employee> emplSalaryGraterThan = empl.getSalaryGraterThan(1500L);
            emplSalaryGraterThan.forEach(System.out::println);
            System.out.println();
            List<Employee> emplSalaryGraterThanOrderDesc = empl.getSalaryGraterThanOrderDesc(1000L);
            emplSalaryGraterThanOrderDesc.forEach(System.out::println);
            System.out.println();
            List<Employee> emplSalaryLess = empl.getSalaryLessOrEqual(1500L);
            emplSalaryLess.forEach(System.out::println);
System.out.println();
            List<Employee> emplByAgeBetween = empl.getByAgeBetween(35, 45);
            emplByAgeBetween.forEach(System.out::println);
System.out.println();
            List<Employee> emplBAgeAndName = empl.getByAgeAndName("Dina", 45);
            emplBAgeAndName.forEach(System.out::println);
System.out.println();
            List<Employee> emplByAgeOrName = empl.getByAgeOrName("Dina", 45);
            emplByAgeOrName.forEach(System.out::println);
System.out.println();

            Long employeeCount = empl.getEmployeeCount();
            log.info(employeeCount.toString());

            Double averageSalary = empl.getAverageSalary();
            log.info(averageSalary.toString());

            Double maxSalary = empl.getMaxSalary();
            log.info(maxSalary.toString());

            Integer minAge = empl.getMinAge();
            log.info(minAge.toString());

            Double averageSalaryByDep = empl.getAverageSalaryByDep(1L);
            log.info(averageSalaryByDep.toString());
        } finally {
            HibernateUtil.shutdown();
        }

    }
}
