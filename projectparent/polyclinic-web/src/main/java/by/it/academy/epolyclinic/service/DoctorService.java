package by.it.academy.epolyclinic.service;

import by.it.academy.epolyclinic.clinic.Doctor;

import java.util.List;

public interface DoctorService {

    List<Doctor> getAllDoctors();

    void addNewDoctor(Doctor doctor);
}
