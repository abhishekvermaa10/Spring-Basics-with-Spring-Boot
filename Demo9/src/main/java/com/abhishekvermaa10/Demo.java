package com.abhishekvermaa10;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.abhishekvermaa10.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
//SS -> 1 Service, 1 Repository
//PS -> 2 Service, 1 Repository
//PP -> 2 Service, 2 Repository
//SP -> 1 Service, 1 Repository
@SpringBootApplication
public class Demo implements CommandLineRunner {
	@Autowired
	private OwnerService ownerService1;
	@Autowired
	private OwnerService ownerService2;

	public static void main(String[] args) {
		SpringApplication.run(Demo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Before modifying ownerId of ownerService1");
			System.out.println("ownerService1 : " + ownerService1.findOwner());
			System.out.println("ownerService2 : " + ownerService2.findOwner());
			System.out.println("Enter id of owner:");
			int ownerId = scanner.nextInt();
			ownerService1.modifyOwnerId(ownerId);
			System.out.println("After modifying ownerId of ownerService1");
			System.out.println("ownerService1 : " + ownerService1.findOwner());
			System.out.println("ownerService2 : " + ownerService2.findOwner());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}
