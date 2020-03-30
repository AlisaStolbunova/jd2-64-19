package by.it.academy.clinic.service;

import by.it.academy.clinic.entity.Meeting;
import by.it.academy.clinic.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    @Transactional
    public void addAll(List<Meeting> meetings){
        meetingRepository.saveAll(meetings);
    }

    public List<Meeting> findBySubject(String subject){
        return meetingRepository.findAllBySubject(subject);
    }

    public List<Meeting> findByStartDateBetween(LocalDateTime start, LocalDateTime finish){
        return meetingRepository.findByStartDateBetween(start, finish);
    }

    public List<Meeting> findBySubjectOrderByStartDate(String subject){
        return meetingRepository.findBySubjectOrderByStartDate(subject);
    }
}
