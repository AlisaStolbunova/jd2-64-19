package aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class AopAnnotation {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
        TaskServiceAnnotation bean = (TaskServiceAnnotation) context.getBean("taskServiceAnnotation");
        bean.performJob("Spring");
        bean.performJob();
        bean.performJobAround();
        try{
            bean.performExceptionJob();
        }catch (Exception e){
            log.error(String.valueOf(e));
        }
        ((ClassPathXmlApplicationContext) context).close();

    }

}
