package com.scaleupindia.repository.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.scaleupindia.exception.OwnerNotFoundException;
import com.scaleupindia.repository.OwnerRepository;

/**
 * @author abhishekvermaa10
 *
 */
@Repository
@Profile("prod")
public class OwnerRepositoryImpl implements OwnerRepository {
	@Value("${owner.found}")
	private String ownerFound;
	@Value("${owner.not.found}")
	private String ownerNotFound;

	public OwnerRepositoryImpl() {
		System.out.println("OwnerRepositoryImpl bean created.");
	}

	@Override
	public String findOwner(int ownerId) throws OwnerNotFoundException {
		if (ownerId % 2 == 0) {
			return ownerFound + ownerId;
		} else {
			throw new OwnerNotFoundException(ownerNotFound + ownerId);
		}
	}
}
