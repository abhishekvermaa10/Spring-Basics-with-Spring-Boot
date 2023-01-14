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
	@Bean
	public OwnerService ownerService() {
		return new OwnerServiceImpl(ownerRepository(), 10);
	}

	@Bean
	public OwnerRepository ownerRepository() {
		return new OwnerRepositoryImpl();
	}
}
