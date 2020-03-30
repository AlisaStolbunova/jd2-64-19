package by.it.academy.clinic.service;

import by.it.academy.clinic.entity.Department;
import by.it.academy.clinic.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public void findByID(){
        Optional<Department> department = departmentRepository.findById(2L);
    }

    @Transactional
    public Iterable<Department> add(List<Department> departments){
        return departmentRepository.saveAll(departments);
    }

    public Department findByName(String departmentName){
        return departmentRepository.findByDepartmentName(departmentName);
    }
}
