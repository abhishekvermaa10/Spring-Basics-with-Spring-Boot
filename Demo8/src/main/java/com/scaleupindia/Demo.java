package com.scaleupindia;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.scaleupindia.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
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
		System.out.println("Before changing ownerId of ownerService1");
		System.out.println("ownerService1 : " + ownerService1.findOwner());
		System.out.println("ownerService2 : " + ownerService2.findOwner());
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id of owner to be fetched:");
		int ownerId = scanner.nextInt();
		ownerService1.setOwnerId(ownerId);
		System.out.println("After changing ownerId of ownerService1");
		System.out.println("ownerService1 : " + ownerService1.findOwner());
		System.out.println("ownerService2 : " + ownerService2.findOwner());
		scanner.close();
	}
}
