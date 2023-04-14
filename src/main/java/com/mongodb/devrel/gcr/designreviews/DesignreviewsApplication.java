package com.mongodb.devrel.gcr.designreviews;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.MongoRepository;

@SpringBootApplication
public class DesignreviewsApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepo;

	public static void main(String[] args) {
		SpringApplication.run(DesignreviewsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// save an airline
		customerRepo.save(new Customer("GCR2103", "Graeme Robinson", new Date(74, 2, 21)));
		customerRepo.save(new Customer("NG9876", "Norman Graham", new Date(70,6,14)));
		customerRepo.save(new Customer("AM1234", "Andrew Morgan", new Date(82,9,20)));


		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerRepo.findAll()) {
			System.out.println(customer);
		}

		System.out.println();
		
		// fetch a specific customer by ID
		System.out.println("Customer found with findById():");
		System.out.println("-------------------------------");
		Optional<Customer> customerResponse = customerRepo.findById("GCR2103");
		System.out.println(customerResponse.get());

		System.out.println();

		// find customers with a specific birth month
		System.out.println("Customers found with findByBirthMonth():");
		System.out.println("-------------------------------");
		for (Customer customer : customerRepo.findCustomerByBirthMonth(3)) {
			System.out.println(customer);
		}

		System.out.println();

		// find customers with a birth year more recent than a given value
		System.out.println("Customers found with findCustomerYoungerThanBirthYear():");
		System.out.println("-------------------------------");
		for (Customer customer : customerRepo.findCustomerYoungerThanBirthYear(1971)) {
			System.out.println(customer);
		}

		System.out.println();

		// find customers with a specific DOB
		System.out.println("Customers found with findByDOB():");
		System.out.println("-------------------------------");
		for (Customer customer : customerRepo.findCustomerByDOB(new Date(70, 6 , 14))) {
			System.out.println(customer);
		}
		

	}
}

