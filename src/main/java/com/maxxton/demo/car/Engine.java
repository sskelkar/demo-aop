package com.maxxton.demo.car;

import org.springframework.stereotype.Component;

@Component
public class Engine {

  public void start() {
    System.out.println("Engine started");
  }
  
  public void stop() {
    System.out.println("Engine stopped");
  }
}
