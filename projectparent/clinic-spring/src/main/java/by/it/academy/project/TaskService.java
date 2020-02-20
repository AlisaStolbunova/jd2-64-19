package by.it.academy.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service("taskService")
public class TaskService {

    public void performJob(){
        log.info("Perform job");
    }

    public void performExceptionJob() throws Exception{
        log.info("Throws exception in Job");

        throw new Exception("Exception Job");
    }
}
