package com.scaleupindia.service.impl;

import com.scaleupindia.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerServiceImpl implements OwnerService {
	private int ownerId;

	public OwnerServiceImpl(int ownerId) {
		this.ownerId = ownerId;
		System.out.println("OwnerServiceImpl bean created.");
	}

	@Override
	public String findOwner() {
		return "Found owner with ownerId " + ownerId;
	}
}
