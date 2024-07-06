package com.abhishekvermaa10.repository.impl;

import com.abhishekvermaa10.repository.OwnerRepository;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerRepositoryImpl implements OwnerRepository {
	public OwnerRepositoryImpl() {
		System.out.println("OwnerRepositoryImpl bean created.");
	}

	@Override
	public String findOwner(int ownerId) {
		return String.format("Found owner from repository with ownerId %s", ownerId);
	}
}
