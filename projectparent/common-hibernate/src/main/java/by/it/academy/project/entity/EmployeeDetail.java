package by.it.academy.project.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "EMPLOYEE_DETAILS")
public class EmployeeDetail {
    @Id
    @GenericGenerator(name = "one-one", strategy = "foreign", parameters = @Parameter(name = "property", value = "employee"))
    @GeneratedValue(generator = "one-one")
    @Column(name = "EMPLOYEE_ID")
    @Access(AccessType.PROPERTY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn @Access(AccessType.PROPERTY)
    private Employee employee;

}
