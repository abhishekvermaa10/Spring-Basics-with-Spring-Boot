package com.scaleupindia.service.impl;

import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerServiceImpl2 implements OwnerService {
	private OwnerRepository ownerRepository;
	private int ownerId;

	public OwnerServiceImpl2(OwnerRepository ownerRepository, int ownerId) {
		this.ownerRepository = ownerRepository;
		this.ownerId = ownerId;
		System.out.println("OwnerServiceImpl2 bean created.");
	}

	@Override
	public String findOwner() {
		return ownerRepository.findOwner(ownerId);
	}
}
