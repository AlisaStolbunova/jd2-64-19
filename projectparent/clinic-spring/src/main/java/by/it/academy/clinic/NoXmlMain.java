package by.it.academy.clinic;

import by.it.academy.clinic.bean.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NoXmlMain {

    @Autowired
    private PersonService personService;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(NoXMLConfiguration.class);
        applicationContext.refresh();
        applicationContext.start();
        try {
            NoXmlMain noXmlMain = applicationContext.getBean(NoXmlMain.class);
            log.info("Name: {}", noXmlMain.personService.getPersonName());
        } catch (Exception e) {
            log.error("Error ", e);
        } finally {
            applicationContext.close();
        }
    }
}
