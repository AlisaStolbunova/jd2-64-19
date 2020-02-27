package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
public class WorkAnnotation {

    private static Logger log = LoggerFactory.getLogger(WorkAnnotation.class);

    @Pointcut("execution(* by.it.academy.project.TaskService.performJob()")
    public void performance(){}

    @Pointcut("execution(* by.it.academy.project.TaskService.performJob(String)) && args(name)")
    public void intercept(String name){}

    @Before("performance()")
    public void beforeWork(){
        log.info("Before work");
    }

    @AfterReturning("performance()")
    public void afterWork(){
        log.info("After work");
    }

    @AfterThrowing("performance()")
    public void afterThrowing(){
        log.info("After throwing");
    }

    public void aroundWork(ProceedingJoinPoint joinPoint){
        try{
            log.info("Start");
            log.info("Begin time: = " + System.currentTimeMillis());
            String result = (String) joinPoint.proceed();
            log.info("Finish time: = " + System.currentTimeMillis());
            log.info("Status: " + result);

        }catch(Throwable throwable){
            log.error(String.valueOf(throwable));
        }
    }

    @Before("intercept(name)")
    public void interceptWorkName(String name){
        log.info("Intercepted work is " + name);
    }




}
