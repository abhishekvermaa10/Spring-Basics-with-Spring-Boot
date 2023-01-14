package com.scaleupindia;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private OwnerService ownerService;
	private static Logger logger = LoggerFactory.getLogger(Demo.class);

	public static void main(String[] args) {
		SpringApplication.run(Demo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try (Scanner scanner = new Scanner(System.in)) {
			logger.info(ownerService.findOwner());
			System.out.println("Enter id of owner to be fetched:");
			int ownerId = scanner.nextInt();
			ownerService.setOwnerId(ownerId);
			logger.info(ownerService.findOwner());
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
		}
	}
}
