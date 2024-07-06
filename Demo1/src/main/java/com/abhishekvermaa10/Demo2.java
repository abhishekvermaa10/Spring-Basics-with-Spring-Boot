package com.abhishekvermaa10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.abhishekvermaa10.config.SpringConfig;
import com.abhishekvermaa10.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		OwnerService ownerService = (OwnerService)context.getBean("ownerService");
		System.out.println(ownerService.findOwner());
		((AnnotationConfigApplicationContext)context).close();
	}
}
