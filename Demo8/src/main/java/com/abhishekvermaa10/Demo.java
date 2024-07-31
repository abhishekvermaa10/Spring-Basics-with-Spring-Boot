package com.abhishekvermaa10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.abhishekvermaa10.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
//@Configuration + @EnableAutoConfiguration + @ComponentScan
@SpringBootApplication
public class Demo implements CommandLineRunner {
	@Autowired
	private OwnerService ownerService;

	public static void main(String[] args) {
		SpringApplication.run(Demo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(ownerService.findOwner());
	}
}
