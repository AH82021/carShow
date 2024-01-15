package com.binary.carShow;

import com.binary.carShow.entity.Car;
import com.binary.carShow.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//@EnableAutoConfiguration This enables Spring Boot automatic configuration.Spring Boot will automatically configure your project based on the dependencies.
// For example, if you have the spring-boot-starter-web dependency, Spring Boot assumes that you are developing a web application and confiigures your application accordingly.
//@ComponentScan // This enables the Spring Boot component scan to find all of the components in the application
//@Configuration // This annotation is used to define a configuration class that provides beans to the Spring application context.
@SpringBootApplication
public class CarShowApplication implements CommandLineRunner {
	@Autowired
	private CarRepository carRepository;
private static final Logger logger = LoggerFactory.getLogger(CarShowApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(CarShowApplication.class, args);
	   logger.info("Application started");

	}

	@Override
	public void run(String... args) throws Exception {

		List<Car> cars = Arrays.asList(
				new Car("Ford","Lighting","Gray","FL-234",2023,75000),
				new Car("Nissan","Leaf","Green","BFG-345",2022,40000),
				new Car("Toyota","Sienna","Silver","CDF-233",2024,60000),
				new Car("Honda","Accord","White","HW-345",2024,57000)
		);
		carRepository.saveAll(cars);


		carRepository.
				findAll().forEach(car -> logger.info(car.getMake()+" "+ car.getModel()));


	}

	// ORM (Object Relational Mapping) : is a technique that allows you to fetch from and manipulate a database
	// by using  OOP paradigm. -> Hibernate
	// JPA :
// class  Book (id, title,author, price)  -> Table Book( id, title, author, price)
	//entity -> table
}
