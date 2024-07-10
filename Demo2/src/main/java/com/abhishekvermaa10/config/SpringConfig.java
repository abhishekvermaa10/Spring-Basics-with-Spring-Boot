package com.abhishekvermaa10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.abhishekvermaa10.repository.OwnerRepository;
import com.abhishekvermaa10.repository.impl.OwnerRepositoryImpl;
import com.abhishekvermaa10.service.OwnerService;
import com.abhishekvermaa10.service.impl.OwnerServiceImpl;

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
