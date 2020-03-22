package by.it.academy.project.DAO;

import by.it.academy.project.entity.Department;
import by.it.academy.project.entity.Employee;
import by.it.academy.project.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.*;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private static final EmployeeDaoImpl INSTANCE = new EmployeeDaoImpl();

    public static EmployeeDaoImpl getINSTANCE() {
        return INSTANCE;
    }

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();


    @Override
    public List<Employee> getAll() {
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot);
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery(criteria).getResultList();
        session.close();
        return employees;
    }

    @Override
    public List<Employee> getByName(String name) {
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> emp = criteria.from(Employee.class);
        criteria.select(emp).where(cb.equal(emp.get("firstName"), name));
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery(criteria).getResultList();
        session.close();
        return employees;
    }

    @Override
    public List<Employee> getAllWithNameNotNull() {
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> emp = criteria.from(Employee.class);
        criteria.select(emp).where(cb.isNotNull(emp.get("firstName")));
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery(criteria).getResultList();
        session.close();
        return employees;
    }

    @Override
    public List<Employee> getSalaryGraterThan(Long salary) {
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> emp = criteria.from(Employee.class);
        criteria.select(emp).where(cb.gt(emp.get("salary"), salary));
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery(criteria).getResultList();
        session.close();
        return employees;
    }

    @Override
    public List<Employee> getSalaryGraterThanOrderDesc(Long salary) {
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> emp = criteria.from(Employee.class);
        criteria.orderBy(cb.desc(emp.get("salary"))).where(cb.gt(emp.get("salary"), salary));
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery(criteria).getResultList();
        session.close();
        return employees;
    }

    @Override
    public List<Employee> getSalaryLessOrEqual(Long salary) {
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> emp = criteria.from(Employee.class);
        criteria.select(emp).where(cb.le(emp.get("salary"), salary));
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery(criteria).getResultList();
        session.close();
        return employees;
    }

    @Override
    public List<Employee> getByAgeBetween(Integer from, Integer to) {
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> emp = criteria.from(Employee.class);
        criteria.select(emp).where(cb.between(emp.get("age"), from, to));
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery(criteria).getResultList();
        session.close();
        return employees;
    }

    @Override
    public List<Employee> getByAgeAndName(String name, Integer age) {
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> emp = criteria.from(Employee.class);
        Predicate predicate = cb.and
                (cb.equal(emp.get("firstName"), name),
                        cb.equal(emp.get("age"), age));
        criteria.select(emp).where(predicate);
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery(criteria).getResultList();
        session.close();
        return employees;
    }

    @Override
    public List<Employee> getByAgeOrName(String name, Integer age) {
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> emp = criteria.from(Employee.class);
        Predicate predicate = cb.or
                (cb.equal(emp.get("firstName"), name),
                        cb.equal(emp.get("age"), age));
        criteria.select(emp).where(predicate);
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery(criteria).getResultList();
        session.close();
        return employees;
    }

    @Override
    public long getEmployeeCount() {
        CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
        criteria.select(cb.count(criteria.from(Employee.class)));
        Session session = sessionFactory.openSession();
        Long count = session.createQuery(criteria).getSingleResult();
        session.close();
        return count;
    }

    @Override
    public Double getAverageSalary() {
        CriteriaQuery<Double> criteria = cb.createQuery(Double.class);
        criteria.select(cb.avg(criteria.from(Employee.class).get("salary")));
        Session session = sessionFactory.openSession();
        Double avg = session.createQuery(criteria).getSingleResult();
        session.close();
        return avg;
    }

    @Override
    public Double getMaxSalary() {
        CriteriaQuery<Double> criteria = cb.createQuery(Double.class);
        criteria.select(cb.max(criteria.from(Employee.class).get("salary")));
        Session session = sessionFactory.openSession();
        Double maxSalary = session.createQuery(criteria).getSingleResult();
        session.close();
        return maxSalary;
    }

    @Override
    public long getMinAge() {
        CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
        criteria.select(cb.min(criteria.from(Employee.class).get("age")));
        Session session = sessionFactory.openSession();
        Long minAge = session.createQuery(criteria).getSingleResult();
        session.close();
        return minAge;
    }

    @Override
    public Double getAverageSalaryByDep(Long depId) {
        CriteriaQuery<Double> criteria = cb.createQuery(Double.class);
        Root<Employee> employee = criteria.from(Employee.class);
        Join<Employee,Department> employeeJoin = employee.join("department", JoinType.INNER);
        criteria.select(cb.avg(employee.get("salary"))).where(cb.equal(employeeJoin.get("department"), depId));
        Session session = sessionFactory.openSession();
        Double avg = session.createQuery(criteria).getSingleResult();
        return avg;
    }


}
