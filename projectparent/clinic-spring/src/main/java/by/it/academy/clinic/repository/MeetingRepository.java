package by.it.academy.clinic.repository;

import by.it.academy.clinic.entity.Meeting;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MeetingRepository extends CrudRepository<Meeting, Long> {

    List<Meeting> findAllBySubject(String subject);

    List<Meeting> findByStartDateBetween(LocalDateTime start, LocalDateTime finish);

    List<Meeting> findBySubjectOrderByStartDate(String subject);
}
