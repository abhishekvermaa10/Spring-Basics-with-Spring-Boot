package com.scaleupindia.repository.impl;

import org.springframework.stereotype.Repository;

import com.scaleupindia.repository.OwnerRepository;

/**
 * @author abhishekvermaa10
 *
 */
@Repository
public class OwnerRepositoryImpl2 implements OwnerRepository {
	public OwnerRepositoryImpl2() {
		System.out.println("OwnerRepositoryImpl2 bean created.");
	}

	@Override
	public String findOwner(int ownerId) {
		return "Can't find owner with ownerId " + ownerId;
	}
}
