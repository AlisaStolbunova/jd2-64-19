package by.it.academy.project.DAO;

import by.it.academy.project.entity.Employee;
import by.it.academy.project.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
        return null;
    }

    @Override
    public List<Employee> getSalaryGraterThan(Long salary) {
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> emp = criteria.from(Employee.class);
        criteria.select(emp).where(cb.gt(emp.get("salary"), salary));
        List<Employee> employees = sessionFactory.openSession().createQuery(criteria).getResultList();
        return employees;
    }

    @Override
    public List<Employee> getSalaryGraterThanOrderDesc(Long salary) {
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> emp = criteria.from(Employee.class);
        criteria.orderBy(cb.desc(emp.get("salary"))).where(cb.gt(emp.get("salary"), salary));
        List<Employee> employees = sessionFactory.openSession().createQuery(criteria).getResultList();
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
        List<Employee> employees = sessionFactory.openSession().createQuery(criteria).getResultList();
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
        List<Employee> employees = sessionFactory.openSession().createQuery(criteria).getResultList();
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
        List<Employee> employees = sessionFactory.openSession().createQuery(criteria).getResultList();
        return employees;
    }

    @Override
    public long getEmployeeCount() {
        CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
        criteria.select(cb.count(criteria.from(Employee.class)));
        Long count = sessionFactory.openSession().createQuery(criteria).getSingleResult();
        return count;
    }

    @Override
    public Double getAverageSalary() {
        return null;
    }

    @Override
    public Double getMaxSalary() {
        return null;
    }

    @Override
    public long getMinAge() {
        return 0;
    }

    @Override
    public Double getAverageSalaryByDep(Long depId) {
        return null;
    }


}
