package com.scaleupindia.repository.impl;

import org.springframework.stereotype.Repository;

import com.scaleupindia.exception.OwnerNotFoundException;
import com.scaleupindia.repository.OwnerRepository;

/**
 * @author abhishekvermaa10
 *
 */
@Repository
public class OwnerRepositoryImpl implements OwnerRepository {
	public OwnerRepositoryImpl() {
		System.out.println("OwnerRepositoryImpl bean created.");
	}

	@Override
	public String findOwner(int ownerId) throws OwnerNotFoundException {
		if (ownerId % 2 == 0) {
			return "Found owner with ownerId " + ownerId;
		} else {
			throw new OwnerNotFoundException("Can't find owner with ownerId " + ownerId);
		}
	}
}
