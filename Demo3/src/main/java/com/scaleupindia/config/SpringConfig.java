package com.scaleupindia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.repository.impl.OwnerRepositoryImpl;
import com.scaleupindia.service.OwnerService;
import com.scaleupindia.service.impl.OwnerServiceImpl;

/**
 * @author abhishekvermaa10
 *
 */
@Configuration
public class SpringConfig {
	@Bean("service")
	public OwnerService ownerService() {
		OwnerServiceImpl ownerService = new OwnerServiceImpl();
		ownerService.setOwnerRepository(ownerRepository());
		ownerService.setOwnerId(10);
		return ownerService;
	}

	@Bean
	public OwnerRepository ownerRepository() {
		return new OwnerRepositoryImpl();
	}
}
