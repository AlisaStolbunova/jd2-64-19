package by.it.academy.clinic.service;

import by.it.academy.clinic.entity.Employee;
import by.it.academy.clinic.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee add(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee get(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElseThrow(() -> new RuntimeException("Employee with id " + id + " does not exist"));
    }
}
