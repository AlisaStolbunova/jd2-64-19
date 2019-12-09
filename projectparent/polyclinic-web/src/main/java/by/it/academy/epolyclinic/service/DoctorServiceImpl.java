package by.it.academy.epolyclinic.service;

import by.it.academy.epolyclinic.clinic.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorServiceImpl implements DoctorService {

    private static final DoctorService INSTANCE = new DoctorServiceImpl();

    private final List<Doctor> doctors;

    private DoctorServiceImpl() {
        doctors = new ArrayList<>();
        doctors.add(new Doctor(1L, "Podaka Anna", "Physicians", "Therapeutic",
                1, 330, "+375 29 2424561"));
        doctors.add(new Doctor(2L, "Kush Elena", "Physicians", "Therapeutic",
                2, 333, "+375 44 3325671"));
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


    @Override
    public void deleteDoctor(Long id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(id)) {
                doctors.remove(doctor);
            }
        }
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
            }
        }


    }
}
