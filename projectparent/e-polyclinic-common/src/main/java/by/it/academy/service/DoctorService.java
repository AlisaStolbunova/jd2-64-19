package by.it.academy.service;


import by.it.academy.clinic.Doctor;

import java.util.List;

public interface DoctorService {

    List<Doctor> getAllDoctors();

    Long create(String name, String post, Integer department, Integer section, Integer office, String phoneNumber);

    void deleteDoctor(Long id);

    void updateDoctor(Doctor doctor);
}
