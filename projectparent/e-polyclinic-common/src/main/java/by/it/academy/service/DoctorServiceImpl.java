package by.it.academy.service;

import by.it.academy.clinic.Doctor;
import by.it.academy.dao.DoctorDao;
import by.it.academy.dao.impl.DoctorDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DoctorServiceImpl implements DoctorService {

    private static final Logger logger = LoggerFactory.getLogger(DoctorServiceImpl.class);

    private static final DoctorService INSTANCE = new DoctorServiceImpl();
    private final DoctorDao doctorDao = DoctorDaoImpl.getInstance();
    public static DoctorService getInstance() {
        return INSTANCE;
    }

    private final List<Doctor> doctors;
    private AtomicLong id = new AtomicLong();

    private DoctorServiceImpl() {
        doctors = new ArrayList<>();
//        doctors.add(new Doctor(id.incrementAndGet(), "Podaka Anna", "Physicians", "Therapeutic",
//                1, 330, "+375 29 2424561"));
//        doctors.add(new Doctor(id.incrementAndGet(), "Kush Elena", "Physicians", "Therapeutic",
//                2, 333, "+375 44 3325671"));
    }

    public static DoctorService getService() {
        return INSTANCE;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        try {
            return doctorDao.getAll();
        } catch (SQLException e) {
            logger.error("Error during getting all the doctors", e);
        }
        return Collections.emptyList();
    }


    @Override
    public Long create(String name, String post, Integer department, Integer section, Integer office, String phoneNumber){
        Long count = 0L;
        try {
            Doctor doc = new Doctor(name, post,department, section, office, phoneNumber);
            count = doctorDao.create(doc);
        } catch (SQLException e) {
            logger.error("Error! Doctor is not create", e);
        }

        return count;
    }



    @Override
    public void deleteDoctor(Long id) {
        doctors.removeIf(doctor -> id.equals(doctor.getId()));
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        for (Doctor doc : doctors) {
            if (doc.getId().equals(doctor.getId())) {
                doc.setName(doctor.getName());
                doc.setPost(doctor.getPost());
                doc.setDepartment(doctor.getDepartment());
                doc.setSection(doctor.getSection());
                doc.setOffice(doctor.getOffice());
                doc.setPhoneNumber(doctor.getPhoneNumber());
                break;
            }
        }


    }
}
