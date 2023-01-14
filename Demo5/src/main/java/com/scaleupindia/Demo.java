package com.scaleupindia;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

import com.scaleupindia.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
@Configuration
@ComponentScan
public class Demo {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(Demo.class);
		OwnerService ownerService = (OwnerService) context.getBean("ownerServiceImpl");
		System.out.println(ownerService.findOwner());
		context.close();
	}
}
