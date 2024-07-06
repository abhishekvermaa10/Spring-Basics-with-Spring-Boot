package com.abhishekvermaa10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.abhishekvermaa10.config.SpringConfig;
import com.abhishekvermaa10.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
public class Demo3 {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		OwnerService ownerService = context.getBean("ownerServiceReal", OwnerService.class);
		System.out.println(ownerService.findOwner());
		((AnnotationConfigApplicationContext)context).close();
	}
}
