package by.it.academy.project.DAO;

import by.it.academy.project.entity.Employee;
import by.it.academy.project.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDaoHQLImpl implements EmployeeDao {

    private static final EmployeeDaoHQLImpl INSTANCE = new EmployeeDaoHQLImpl();

    public static EmployeeDaoHQLImpl getINSTANCE() {
        return INSTANCE;
    }

    private Session openSession(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session;
    }

    private void commitAndCloseSession(Session session){
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Employee> getAll() {
        Session session = openSession();
        Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = query.list();
        commitAndCloseSession(session);
        return employees;
    }

    @Override
    public List<Employee> getByName(String name) {
        Session session = openSession();
        Query<Employee> query = session.createQuery("FROM Employee where firstName=:name", Employee.class);
        query.setParameter("name", name);
        List<Employee> employees = query.list();
        commitAndCloseSession(session);
        return employees;
    }

    @Override
    public List<Employee> getAllWithNameNotNull() {
        Session session = openSession();
        Query<Employee> query = session.createQuery("FROM Employee where firstName is not null", Employee.class);
        List<Employee> employees = query.list();
        commitAndCloseSession(session);
        return employees;
    }

    @Override
    public List<Employee> getSalaryGraterThan(Long salary) {
        Session session = openSession();
        Query<Employee> query = session.createQuery("FROM Employee where salary > :salary", Employee.class);
        query.setParameter("salary", salary);
        List<Employee> employees = query.list();
        commitAndCloseSession(session);
        return employees;
    }

    @Override
    public List<Employee> getSalaryGraterThanOrderDesc(Long salary) {
        Session session = openSession();
        Query<Employee> query = session.createQuery("FROM Employee where salary > :salary order by salary desc", Employee.class);
        query.setParameter("salary", salary);
        List<Employee> employees = query.list();
        commitAndCloseSession(session);
        return employees;
    }

    @Override
    public List<Employee> getSalaryLessOrEqual(Long salary) {
        Session session = openSession();
        Query<Employee> query = session.createQuery("FROM Employee where salary <= :salary", Employee.class);
        query.setParameter("salary", salary);
        List<Employee> employees = query.list();
        commitAndCloseSession(session);
        return employees;
    }

    @Override
    public List<Employee> getByAgeBetween(Integer from, Integer to) {
        Session session = openSession();
        Query<Employee> query = session.createQuery("FROM Employee where age > :from and age < :to", Employee.class);
        query.setParameter("from", from);
        query.setParameter("to", to);
        List<Employee> employees = query.list();
        commitAndCloseSession(session);
        return employees;
    }

    @Override
    public List<Employee> getByAgeAndName(String name, Integer age) {
        Session session = openSession();
        Query<Employee> query = session.createQuery("FROM Employee where firstName=:name and age=:age", Employee.class);
        query.setParameter("name", name);
        query.setParameter("age", age);
        List<Employee> employees = query.list();
        commitAndCloseSession(session);
        return employees;
    }

    @Override
    public List<Employee> getByAgeOrName(String name, Integer age) {
        Session session = openSession();
        Query<Employee> query = session.createQuery("FROM Employee where firstName=:name or age=:age", Employee.class);
        query.setParameter("name", name);
        query.setParameter("age", age);
        List<Employee> employees = query.list();
        commitAndCloseSession(session);
        return employees;
    }

    @Override
    public long getEmployeeCount() {
        Session session = openSession();
        Query<Long> query = session.createQuery("select count (*) FROM Employee", Long.class);
        long count = query.getSingleResult();
        commitAndCloseSession(session);
        return count;
    }

    @Override
    public Double getAverageSalary() {
        Session session = openSession();
        Query<Double> query = session.createQuery("select avg(salary) FROM Employee", Double.class);
        Double avr = query.getSingleResult();
        commitAndCloseSession(session);
        return avr;
    }

    @Override
    public Double getMaxSalary() {
        Session session = openSession();
        Query<Long> query = session.createQuery("select max(salary) FROM Employee", Long.class);
        Long avr = query.getSingleResult();
        commitAndCloseSession(session);
        return avr.doubleValue();
    }

    @Override
    public Integer getMinAge() {
        Session session = openSession();
        Query<Integer> query = session.createQuery("select min(age) FROM Employee", Integer.class);
        Integer avr = query.getSingleResult();
        commitAndCloseSession(session);
        return avr;
    }

    @Override
    public Double getAverageSalaryByDep(Long depId) {
        Session session = openSession();
        Query<Double> query = session.createQuery("select avg(salary) FROM Employee where department.departmentId=:depId", Double.class);
        query.setParameter("depId", depId);
        Double avr = query.getSingleResult();
        commitAndCloseSession(session);
        return avr;
    }
}
