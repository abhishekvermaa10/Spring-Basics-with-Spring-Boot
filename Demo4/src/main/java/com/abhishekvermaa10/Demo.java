package com.abhishekvermaa10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.abhishekvermaa10.config.SpringConfig;
import com.abhishekvermaa10.repository.OwnerRepository;
import com.abhishekvermaa10.service.OwnerService;
import com.abhishekvermaa10.service.impl.OwnerServiceImpl;

/**
 * @author abhishekvermaa10
 *
 */
public class Demo {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		OwnerService ownerService = context.getBean("ownerServiceImpl", OwnerService.class);
		OwnerRepository ownerRepository = context.getBean("ownerRepositoryImpl", OwnerRepository.class);
		((OwnerServiceImpl)ownerService).setOwnerId(10);
		((OwnerServiceImpl)ownerService).setOwnerRepository(ownerRepository);
		System.out.println(ownerService.findOwner());
		((AnnotationConfigApplicationContext) context).close();
	}
}
