package by.it.academy.epolyclinic.clinic;

import java.util.Objects;

public class Patient {

    private long id;
    private String name;
    private String address;
    private String phoneNumber;
    private Integer section;

    public Patient() {
    }

    public Patient(long id, String name, String address, String phoneNumber, Integer section) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.section = section;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id &&
                Objects.equals(name, patient.name) &&
                Objects.equals(address, patient.address) &&
                Objects.equals(phoneNumber, patient.phoneNumber) &&
                Objects.equals(section, patient.section);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phoneNumber, section);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", section=" + section +
                '}';
    }
}
