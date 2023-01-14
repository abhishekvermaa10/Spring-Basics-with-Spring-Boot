package com.scaleupindia;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.scaleupindia.config.SpringConfig;
import com.scaleupindia.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		OwnerService ownerService = context.getBean("ownerService", OwnerService.class);
		System.out.println(ownerService.findOwner());
		context.close();
	}
}
