package by.it.academy.dao.impl;

import by.it.academy.clinic.Doctor;
import by.it.academy.dao.DoctorDao;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DoctorDaoImpl extends AbstractDao implements DoctorDao {

    private static final DoctorDaoImpl INSTANCE = new DoctorDaoImpl();

    private DoctorDaoImpl() {
        super(LoggerFactory.getLogger(DoctorDaoImpl.class));
    }

    private final DoctorDao doctorDao = DoctorDaoImpl.getInstance();
    public static DoctorDao  getInstance() {
        return INSTANCE;
    }

    private static final String INSERT_DOCTOR = "Insert doctors(name, post, department_id, section_id, office, phoneNumber) values (?,?,?,?,?,?)";
    private static final String SELECT_ALL_DOCTORS = "SELECT * FROM doctors";
    private static final String SELECT_ALL_DEPARTMENTS = "SELECT * FROM department";

    @Override
    public Long create(Doctor doctor) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement(INSERT_DOCTOR);
        statement.setString(1, doctor.getName());
        statement.setString(2, doctor.getPost());
        statement.setInt(3, doctor.getDepartment());
        statement.setInt(4, doctor.getSection());
        statement.setInt(5, doctor.getOffice());
        statement.setString(6, doctor.getPhoneNumber());
        return (long) statement.executeUpdate();

    }

    @Override
    public Optional<Doctor> read(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public int update(Doctor doctor) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Long id) throws SQLException {
        return 0;
    }

    @Override
    public List<Doctor> getAll() throws SQLException {
        List<Doctor> doctors = new ArrayList<>();
        ResultSet rs = null;
        try {
            PreparedStatement statement = getConnection().prepareStatement(SELECT_ALL_DOCTORS);
            rs = statement.executeQuery();
            while (rs.next()) {
                Doctor user = new Doctor(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("post"),
                        rs.getInt("department_id"),
                        rs.getInt("section_id"),
                        rs.getInt("office"),
                        rs.getString("phoneNumber")
                );
                doctors.add(user);
            }
        } finally {
            closeQuietly(rs);
        }
        return doctors;
    }


}
