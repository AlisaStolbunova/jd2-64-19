package by.it.academy.project.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "MEETING")
@Entity
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEETING_ID")
    private Long meetingId;
    private String subject;
    private LocalDateTime startDate;

    @ManyToMany(mappedBy = "meetings")
    private Set<Employee> employees;


    public Meeting(String subject) { this.subject = subject;
        this.startDate = LocalDateTime.now(); }

}
