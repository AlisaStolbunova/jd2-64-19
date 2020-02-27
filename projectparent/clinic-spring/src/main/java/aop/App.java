package aop;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class App {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        TaskService service = (TaskService) context.getBean("taskService");

        service.performJob();
        try{
            service.performExceptionJob();
        }catch (Exception e){
            log.error("Error", e);
        }
        context.close();
    }
}
