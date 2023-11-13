package com.example.employeefilter.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrorLoggingAspect {

    @AfterThrowing(pointcut ="execution(public * com.example.employeefilter.controller..*.*(..))", throwing = "exception")
    @Async
    public void logError(Exception exception) {
        StackTraceElement[] stackTrace = exception.getStackTrace();
        if (stackTrace.length > 0) {
            // Access the first element (top of the call stack)
            StackTraceElement topElement = stackTrace[0];
            Logger logger = LogManager.getLogger(topElement.getClassName());
            logger.error("The error in function : " +
                    topElement.getFileName() + "." +
                    topElement.getMethodName() + " \n at the line : " + topElement.getLineNumber()
                    +"\n error message is : " + exception.getMessage()
            );
        }
    }
}