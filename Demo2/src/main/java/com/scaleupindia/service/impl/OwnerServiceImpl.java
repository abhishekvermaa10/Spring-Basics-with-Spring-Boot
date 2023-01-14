package com.scaleupindia.service.impl;

import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerServiceImpl implements OwnerService {
	private OwnerRepository ownerRepository;
	private int ownerId;

	public OwnerServiceImpl(OwnerRepository ownerRepository, int ownerId) {
		this.ownerRepository = ownerRepository;
		this.ownerId = ownerId;
		System.out.println("OwnerServiceImpl bean created.");
	}

	@Override
	public String findOwner() {
		return ownerRepository.findOwner(ownerId);
	}
}
