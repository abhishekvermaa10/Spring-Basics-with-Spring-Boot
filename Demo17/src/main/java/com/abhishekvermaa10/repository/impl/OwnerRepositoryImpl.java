package com.abhishekvermaa10.repository.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.abhishekvermaa10.exception.OwnerNotFoundException;
import com.abhishekvermaa10.repository.OwnerRepository;

/**
 * @author abhishekvermaa10
 *
 */
@Repository
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
			return String.format(ownerFound, ownerId);
		} else {
			throw new OwnerNotFoundException(String.format(ownerNotFound, ownerId));
		}
	}
}
