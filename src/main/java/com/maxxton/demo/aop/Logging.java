package com.maxxton.demo.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logging {

  private static final Logger LOGGER = Logger.getLogger(Logging.class);

  @Before("execution(* com.maxxton.demo.car.*.*())")
  public void noArgumentMethodInvoked(JoinPoint joinPoint) {
    LOGGER.info("calling " + joinPoint.getSignature().getName());
  }
  
  @Before("execution(* com.maxxton.demo.car.Navigator.move(..)) && args(distance)")
  public void logDistance(JoinPoint joinPoint, Long distance) {
    LOGGER.info("moving by " + distance + "m");
  }
  
  @AfterThrowing(pointcut="within(com.maxxton.demo..*)", throwing="ex")
  public void logException(JoinPoint joinPoint, Exception ex) {
    LOGGER.error("Some problem occurred in " + joinPoint.getSignature().getName() + ", error message - " +  ex.getMessage());
  }
}
