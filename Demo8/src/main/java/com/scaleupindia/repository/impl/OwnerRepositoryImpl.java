package com.scaleupindia.repository.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.scaleupindia.repository.OwnerRepository;

/**
 * @author abhishekvermaa10
 *
 */
@Repository
@Scope("singleton")
public class OwnerRepositoryImpl implements OwnerRepository {
	public OwnerRepositoryImpl() {
		System.out.println("OwnerRepositoryImpl bean created.");
	}

	@Override
	public String findOwner(int ownerId) {
		return "Found owner with ownerId " + ownerId;
	}
}
