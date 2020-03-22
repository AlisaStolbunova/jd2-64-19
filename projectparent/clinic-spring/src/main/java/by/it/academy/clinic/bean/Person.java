package by.it.academy.clinic.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@NoArgsConstructor
@Component
public class Person {

    @Value("1")
    private Long id;
    @Value("Ivan Ivanov")
    private String name;
    @Autowired()
    @Qualifier("address")
    private IAddress IAddress;

    public void init(){
        log.info("init method of Person");
    }

    public void destroy(){
        log.info("destroy method of Person");
    }
}
