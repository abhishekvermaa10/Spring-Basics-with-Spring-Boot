package com.abhishekvermaa10.repository.impl;

import org.springframework.stereotype.Repository;

import com.abhishekvermaa10.repository.OwnerRepository;

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
	public String findOwner(int ownerId) {
		return String.format("Found owner with ownerId %s", ownerId);
	}
}
