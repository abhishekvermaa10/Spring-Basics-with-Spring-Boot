package com.scaleupindia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.repository.impl.OwnerRepositoryImpl;
import com.scaleupindia.service.OwnerService;
import com.scaleupindia.service.impl.OwnerServiceImpl;
import com.scaleupindia.service.impl.OwnerServiceImpl2;

/**
 * @author abhishekvermaa10
 *
 */
@Configuration
public class SpringConfig {
	@Bean
	public OwnerService ownerService() {
		return new OwnerServiceImpl(10);
	}

	@Bean
	public OwnerService ownerService2() {
		return new OwnerServiceImpl2(ownerRepository(), 10);
	}

	@Bean
	public OwnerRepository ownerRepository() {
		return new OwnerRepositoryImpl();
	}
}
