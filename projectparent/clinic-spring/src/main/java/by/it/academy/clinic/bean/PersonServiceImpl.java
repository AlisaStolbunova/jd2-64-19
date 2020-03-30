package by.it.academy.clinic.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private Person person;

    @PostConstruct
    public void init() {
        log.info("Post construct");
    }

    @Override
    public String getPersonName() {
        return person.getName();
    }

    @PreDestroy
    public void destroy() {
        log.info("Pre destroy");
    }
}
