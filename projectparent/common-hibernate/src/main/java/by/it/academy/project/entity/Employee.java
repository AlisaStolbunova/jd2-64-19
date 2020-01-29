package by.it.academy.project.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "EMPLOYEE")
public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID", unique = true)
    @Access(AccessType.PROPERTY)
    private Long employeeId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "LOCAL_DATETIME")
    private LocalDateTime date;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
    private EmployeeDetail employeeDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "EMPLOYEE_MEETING", joinColumns = {@JoinColumn(name = "EMPLOYEE_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "MEETING_ID")})
//    private List<Meeting> meetings = new ArrayList<>();

}
