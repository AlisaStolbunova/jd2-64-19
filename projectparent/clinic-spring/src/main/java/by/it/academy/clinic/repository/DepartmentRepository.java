package by.it.academy.clinic.repository;

import by.it.academy.clinic.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
    Department findByDepartmentName(String name);
}
