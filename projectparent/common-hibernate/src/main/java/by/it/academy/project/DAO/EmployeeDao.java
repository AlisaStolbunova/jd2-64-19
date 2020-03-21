package by.it.academy.project.DAO;

import by.it.academy.project.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAll();

    List<Employee> getByName(String name);

    List<Employee> getAllWithNameNotNull();

    List<Employee> getSalaryGraterThan(Long salary);

    List<Employee> getSalaryGraterThanOrderDesc(Long salary);

    List<Employee> getSalaryLessOrEqual(Long salary);

    List<Employee> getByAgeBetween(Integer from, Integer to);

    List<Employee> getByAgeAndName(String name, Integer age);

    List<Employee> getByAgeOrName(String name, Integer age);


    // aggregation
    long getEmployeeCount();

    Double getAverageSalary();

    Double getMaxSalary();

    Integer getMinAge();

    Double getAverageSalaryByDep(Long depId);
}