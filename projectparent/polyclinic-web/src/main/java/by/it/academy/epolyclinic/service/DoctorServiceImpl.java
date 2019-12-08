package by.it.academy.epolyclinic.service;

import by.it.academy.epolyclinic.clinic.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorServiceImpl implements DoctorService {

    private static final DoctorService INSTANCE = new DoctorServiceImpl();

    private final List<Doctor> doctors;

    private DoctorServiceImpl() {
        doctors = new ArrayList<>();
        doctors.add(new Doctor(1L, "Doctor_1", "Physicians", "Therapeutic",
                1, 330, 123456789L));
        doctors.add(new Doctor(2L, "Doctor_2", "Physicians", "Therapeutic",
                2, 333, 123456799L));
    }

    public static DoctorService getService() {
        return INSTANCE;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    @Override
    public void addNewDoctor(Doctor doctor) {
        doctor.setId((long) doctors.size() + 1);
        doctors.add(doctor);
    }
}
