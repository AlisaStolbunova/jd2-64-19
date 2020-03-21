package bean;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person.toString());
        context.close();
    }
}
