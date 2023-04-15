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
		customerRepo.save(new Customer("GCR2103", "Graeme Robinson", new Date(74, 0, 1)));
		customerRepo.save(new Customer("NG9876", "Norman Graham", new Date(70,6,14)));
		customerRepo.save(new Customer("AM1234", "Andrew Morgan", new Date(74,9,20)));


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
		for (Customer customer : customerRepo.findCustomerByBirthDate(new Date(70, 6, 14))) {
			System.out.println(customer);
		}

		System.out.println();

		// find customers with a specific birth year taking timezone into account
		System.out.println("Customers found with findCustomerByBirthYearTZ():");
		System.out.println("-------------------------------");
		System.out.println("Timezone Denver");
		//change this to your own local timezone
		for (Customer customer : customerRepo.findCustomerByBirthYearTZ(1974, "America/Denver")) {
			System.out.println(customer);
		}
		System.out.println("Timezone Los Angeles");
		//Change this to a timezone behind your local zone - you should see a differing result set.
		for (Customer customer : customerRepo.findCustomerByBirthYearTZ(1974, "America/Los_Angeles")) {
			System.out.println(customer);
		}

		System.out.println();

		// find customers with a specific birth year, ignoring timezone
		System.out.println("Customers found with findCustomerByBirthYear():");
		System.out.println("-------------------------------");
		for (Customer customer : customerRepo.findCustomerByBirthYear(1974)) {
			System.out.println(customer);
		}

	}
}

