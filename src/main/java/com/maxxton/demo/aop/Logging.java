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
  
  @Pointcut("execution(* com.maxxton.demo.car.*.*())")
  private void noArgumentMethods() {
  }
  
  @Pointcut("execution(* com.maxxton.demo.car.Navigator.*(..)) && args(distance)")
  private void singleArgumentMethods(Long distance) {
  }
  
  @Pointcut("execution(* com.maxxton.demo.car.Navigator.*(..))")
  private void throwingMethods() {
  }
  
  @Before("noArgumentMethods()")
  public void methodInvoked(JoinPoint joinPoint) {
    LOGGER.info("calling " + joinPoint.getSignature().getName());
  }
  
  @Before("singleArgumentMethods(distance)")
  public void move(JoinPoint joinPoint, Long distance) {
    LOGGER.info("moving by " + distance + "m");
  }
  
  @AfterThrowing(pointcut="throwingMethods()", throwing="ex")
  public void throwing(JoinPoint joinPoint, Exception ex) {
    LOGGER.error("Some problem occurred in " + joinPoint.getSignature().getName() + ", error message - " +  ex.getMessage());
  }
}
