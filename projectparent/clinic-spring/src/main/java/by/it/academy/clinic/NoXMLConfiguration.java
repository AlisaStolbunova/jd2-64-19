package by.it.academy.clinic;

import by.it.academy.clinic.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "by.it.academy.clinic")
public class NoXMLConfiguration {

    @Bean(value = "personBean",
            initMethod = "init", destroyMethod = "destroy")
    public Person getPerson() {
        Person person = new Person();
        return new Person();
    }

}
