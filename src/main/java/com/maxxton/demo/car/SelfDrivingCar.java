package com.maxxton.demo.car;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maxxton.demo.exception.NavigationFailException;

@Component
public class SelfDrivingCar {

  @Autowired private Engine engine;
  @Autowired private Navigator navigator;
    
  public void testDrive() {    
    try { 
      
      engine.start();
      
      navigator.move(100L);
      
      navigator.turnLeft();
      
      navigator.move(50L);
      
      navigator.turnRight();
      
      navigator.move(20L);
      
      engine.stop();  
      
    } catch(NavigationFailException e) {
      // Nothing to do.
    }
  }
  
  
  
}
