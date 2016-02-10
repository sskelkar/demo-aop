package com.maxxton.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.maxxton.demo.car.SelfDrivingCar;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoAopApplication implements CommandLineRunner{

  @Autowired private SelfDrivingCar car;
  
	public static void main(String[] args) {
		SpringApplication.run(DemoAopApplication.class, args);
	}
	
  @Override
  public void run(String... args) throws Exception {
    car.testDrive();
  }
}
