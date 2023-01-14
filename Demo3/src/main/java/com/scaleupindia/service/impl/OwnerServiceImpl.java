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

	public OwnerServiceImpl() {
		System.out.println("OwnerServiceImpl bean created.");
	}

	public void setOwnerRepository(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String findOwner() {
		return ownerRepository.findOwner(ownerId);
	}
}
