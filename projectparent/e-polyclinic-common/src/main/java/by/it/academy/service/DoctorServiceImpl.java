package by.it.academy.service;

import by.it.academy.clinic.Doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DoctorServiceImpl implements DoctorService {

    private static final DoctorService INSTANCE = new DoctorServiceImpl();

    private final List<Doctor> doctors;
    private AtomicLong id = new AtomicLong();

    private DoctorServiceImpl() {
        doctors = new ArrayList<>();
        doctors.add(new Doctor(id.incrementAndGet(), "Podaka Anna", "Physicians", "Therapeutic",
                1, 330, "+375 29 2424561"));
        doctors.add(new Doctor(id.incrementAndGet(), "Kush Elena", "Physicians", "Therapeutic",
                2, 333, "+375 44 3325671"));
    }

    public static DoctorService getService() {
        return INSTANCE;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return new ArrayList<>(doctors);
    }

    @Override
    public void addNewDoctor(Doctor doctor) {
        doctor.setId(id.incrementAndGet());
        doctors.add(doctor);
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
