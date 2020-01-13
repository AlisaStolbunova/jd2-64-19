package by.it.academy.clinic;

import java.util.Objects;

public class Doctor {
    private Long id;
    private String name;
    private String post;
    private Integer department;
    private Integer section;
    private Integer office;
    private String phoneNumber;

    public Doctor() {
    }

    public Doctor(Long id, String name, String post, Integer departmentId,
                  Integer section, Integer office, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.post = post;
        this.department = departmentId;
        this.section = section;
        this.office = office;
        this.phoneNumber = phoneNumber;
    }

    public Doctor(String name, String post, Integer departmentId,
                  Integer section, Integer office, String phoneNumber) {
        this.name = name;
        this.post = post;
        this.department = departmentId;
        this.section = section;
        this.office = office;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer departmentId) {
        this.department = departmentId;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public Integer getOffice() {
        return office;
    }

    public void setOffice(Integer office) {
        this.office = office;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(id, doctor.id) &&
                Objects.equals(name, doctor.name) &&
                Objects.equals(post, doctor.post) &&
                Objects.equals(department, doctor.department) &&
                Objects.equals(section, doctor.section) &&
                Objects.equals(office, doctor.office) &&
                Objects.equals(phoneNumber, doctor.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, post, department, section, office, phoneNumber);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", post='" + post + '\'' +
                ", department='" + department + '\'' +
                ", section=" + section +
                ", office=" + office +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
