package com.scaleupindia.repository.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.scaleupindia.repository.OwnerRepository;

/**
 * @author abhishekvermaa10
 *
 */
@Repository
@Profile("dev")
public class OwnerRepositoryImpl2 implements OwnerRepository {
	@Value("${owner.found}")
	private String ownerFound;

	public OwnerRepositoryImpl2() {
		System.out.println("OwnerRepositoryImpl2 bean created.");
	}

	@Override
	public String findOwner(int ownerId) {
		return ownerFound + ownerId;
	}
}
