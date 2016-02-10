package com.maxxton.demo.car;

import org.springframework.stereotype.Component;

import com.maxxton.demo.exception.NavigationFailException;

@Component
public class Navigator {

  public void turnLeft() throws NavigationFailException {
    System.out.println("Turned Left");
  }
  
  public void turnRight() throws NavigationFailException {
    throw new NavigationFailException("error in right turn");
  }
  
  public void move(Long distance) {
    System.out.print("Drove " + distance + " meters");
  }
}
