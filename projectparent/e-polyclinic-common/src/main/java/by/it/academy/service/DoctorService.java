package by.it.academy.service;


import by.it.academy.clinic.Doctor;

import java.util.List;

public interface DoctorService {

    List<Doctor> getAllDoctors();

    void addNewDoctor(Doctor doctor);


    void deleteDoctor(Long id);

    void updateDoctor(Doctor doctor);
}
