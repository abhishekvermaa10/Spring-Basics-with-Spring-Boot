package com.abhishekvermaa10.repository.impl;

import org.springframework.stereotype.Repository;

import com.abhishekvermaa10.repository.OwnerRepository;

/**
 * @author abhishekvermaa10
 *
 */
@Repository("specialRepository")
public class OwnerRepositoryImpl2 implements OwnerRepository {
	public OwnerRepositoryImpl2() {
		System.out.println("OwnerRepositoryImpl special bean created.");
	}

	@Override
	public String findOwner(int ownerId) {
		return String.format("Found owner with ownerId %s from special repository", ownerId);
	}
}
