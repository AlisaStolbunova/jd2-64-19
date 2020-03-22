package by.it.academy.clinic.dao.impl;

import by.it.academy.clinic.dao.BaseDao;
import by.it.academy.clinic.dao.EmployeeDao;
import by.it.academy.clinic.entity.Employee;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDaoImpl extends BaseDao<Employee> implements EmployeeDao {
    public EmployeeDaoImpl() {
        super(Employee.class);
    }

}
