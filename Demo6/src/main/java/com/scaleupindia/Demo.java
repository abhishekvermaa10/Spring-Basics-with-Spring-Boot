package com.scaleupindia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

import com.scaleupindia.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
@SpringBootApplication
public class Demo {
	public static void main(String[] args) {
		AbstractApplicationContext context = (AbstractApplicationContext) SpringApplication.run(Demo.class, args);
		OwnerService ownerService = (OwnerService) context.getBean("ownerServiceImpl");
		System.out.println(ownerService.findOwner());
		context.close();
	}
}
