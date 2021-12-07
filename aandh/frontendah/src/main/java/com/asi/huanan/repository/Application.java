package com.asi.huanan.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UsermanageRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		repository.deleteAll();
//
//		// save a couple of customers
//		repository.save(new Test("Alice", "Smith"));
//		repository.save(new Test("Bob", "Smith"));
//
//		// fetch all customersl
//		System.out.println("Customers found with findAll():");
//		System.out.println("-------------------------------");
//		for (Test customer : repository.findAll()) {
//			System.out.println(customer);
//		}
//		System.out.println();
//
//		// fetch an individual customer
//		System.out.println("Customer found with findByFirstName('Alice'):");
//		System.out.println("--------------------------------");
//		System.out.println(repository.findByFirstName("Alice"));
//
//		System.out.println("Customers found with findByLastName('Smith'):");
//		System.out.println("--------------------------------");
//		for (Test customer : repository.findByLastName("Smith")) {
//			System.out.println(customer);
//		}

	}

}