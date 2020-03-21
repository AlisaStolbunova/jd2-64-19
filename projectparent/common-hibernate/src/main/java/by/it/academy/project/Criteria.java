package by.it.academy.project;


import by.it.academy.project.DAO.EmployeeDao;
import by.it.academy.project.DAO.EmployeeDaoCriteriaImpl;
import by.it.academy.project.entity.Department;
import by.it.academy.project.entity.Employee;
import by.it.academy.project.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;


import java.util.List;

@Slf4j
public class Criteria {

    private static final EmployeeDao empl = EmployeeDaoCriteriaImpl.getINSTANCE();

    public static void main(String[] args) {
        try {
            init();

            List<Employee> employees = empl.getAll();
            employees.forEach(System.out::println);

            List<Employee> emplGetByName = empl.getByName("Ivan");
            emplGetByName.forEach(System.out::println);

            List<Employee> emplAllWithNameNotNull = empl.getAllWithNameNotNull();
            emplAllWithNameNotNull.forEach(System.out::println);

            List<Employee> emplSalaryGraterThan = empl.getSalaryGraterThan(1500L);
            emplSalaryGraterThan.forEach(System.out::println);

            List<Employee> emplSalaryGraterThanOrderDesc = empl.getSalaryGraterThanOrderDesc(1000L);
            emplSalaryGraterThanOrderDesc.forEach(System.out::println);

            List<Employee> emplSalaryLess = empl.getSalaryLessOrEqual(1500L);
            emplSalaryLess.forEach(System.out::println);

            List<Employee> emplByAgeBetween = empl.getByAgeBetween(35, 45);
            emplByAgeBetween.forEach(System.out::println);

            List<Employee> emplBAgeAndName = empl.getByAgeAndName("Dina", 45);
            emplBAgeAndName.forEach(System.out::println);

            List<Employee> emplByAgeOrName = empl.getByAgeOrName("Dina", 45);
            emplByAgeOrName.forEach(System.out::println);


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

    static void init() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Department dep1 = new Department("Revision");
        session.save(dep1);
        Department dep2 = new Department("Accountan");
        session.save(dep2);
        Department dep3 = new Department("Mechanic");
        session.save(dep3);
        Department dep4 = new Department("Accountan");
        session.save(dep4);

        Employee empl1 = new Employee(null, "Kosinskaya", "Irina", 41, 1500L, null);
        empl1.setDepartment(dep1);
        session.save(empl1);

        Employee empl2 = new Employee(null, "Korzik", "Dina", 35, 1800L, null);
        empl2.setDepartment(dep2);
        session.save(empl2);

        Employee empl3 = new Employee(null, "Ivanov", "Ivan", 32, 1300L, null);
        empl3.setDepartment(dep3);
        session.save(empl3);

        Employee empl4 = new Employee(null, "Petrov", "Sergey", 45, 2000L, null);
        empl4.setDepartment(dep4);
        session.save(empl4);

        Employee empl5 = new Employee(null, "Ivan", "Sergey", 27, 800L, null);
        empl5.setDepartment(dep4);
        session.save(empl5);

        session.getTransaction().commit();
        session.close();
    }

}
