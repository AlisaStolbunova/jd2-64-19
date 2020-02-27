package aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("taskServiceAnnotation")
public class TaskServiceAnnotation {
    private static Logger log = LoggerFactory.getLogger(TaskServiceAnnotation.class);

    public void performJob(){
        log.info("Perform job");
    }

    public void performExceptionJob() throws Exception{
        log.info("Throw exception in Job");
        throw new Exception("ExceptionJob");
    }

    public String performJobAround(){
        log.info("Perform around job");
        return "SUCCESS";
    }

    public void performJob(String name){
        log.info("Job name: " + name);
    }
}
